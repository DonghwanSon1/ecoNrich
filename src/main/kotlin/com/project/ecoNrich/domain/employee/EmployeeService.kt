package com.project.ecoNrich.domain.employee


import com.project.ecoNrich.common.exception.CommonException
import com.project.ecoNrich.common.exception.CommonExceptionCode
import com.project.ecoNrich.domain.employee.entity.Employee
import com.project.ecoNrich.domain.employee.entity.EmployeeDetailView
import com.project.ecoNrich.domain.employee.entity.JobHistory
import com.project.ecoNrich.domain.employee.repository.EmployeeDetailViewRepository
import com.project.ecoNrich.domain.employee.repository.EmployeeRepository
import com.project.ecoNrich.domain.employee.repository.JobHistoryRepository
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRq
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRs
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.LocalDate

@Service
@Transactional(readOnly = true)
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val employeeDetailViewRepository: EmployeeDetailViewRepository,
    private val jobHistoryRepository: JobHistoryRepository,
) {

  /**
   * 특정 사원 조회
   */
  fun searchEmployee(employeeId: Long): EmployeeRs {
    // 특정 사원을 조회하여 조회시 없으면, Exception 발생하고 있으면 Rs 형식에 맞춰 응답한다.
    val entity: EmployeeDetailView = employeeDetailViewRepository.findById(employeeId).orElseThrow{
      CommonException(CommonExceptionCode.EMPLOYEE_NOT_EXIST) }

    return EmployeeRs.of(entity)
  }

  /**
   * 특정 사원 이력 조회
   */
  fun searchEmployeeHistory(employeeId: Long): List<EmployeeHistoryRs> {
    // 특정 사원의 이력 조회를 하여 없으면 빈배열로 있다면, Rs 형식에 맞춰 응답한다.
    return jobHistoryRepository.searchEmployeeHistory(employeeId)
  }

  /**
   * 사원 정보 수정
   */
  @Transactional
  fun updateEmployee(employeeId: Long, rq: EmployeeRq): String {
    // 사원을 조회하여 없다면, Exception 을 발생하고 있다면, update 하고 성공 메시지를 응답한다.
    val entity: Employee = employeeRepository.findById(employeeId).orElseThrow{
      CommonException(CommonExceptionCode.EMPLOYEE_NOT_EXIST) }

    // 만약 직업 또는 부서를 수정하였다면, 이력에도 저장할 수 있도록 한다.
    if (rq.jobId != null || rq.departmentId != null) {
      // 이력 테이블에 담을 시작 시간은 이력이 있다면 endDate 기점 +1일 하여 startDate 가 될것이고, 없다면 고용일에 startDate 가 된다.
      val startDate: LocalDate =
          jobHistoryRepository.searchRecentHistory(employeeId)?.endDate?.plusDays(1) ?: entity.hireDate!!
      // 끝 일자는 수정한 날로 지정한다.
      val endDate: LocalDate = LocalDate.now()
      jobHistoryRepository.save(JobHistory.createJobHistory(employeeId, startDate, endDate, entity.job!!.jobId!!, entity.department!!.departmentId!!))
    }

    employeeRepository.save(entity.update(rq))

    return "사원 정보를 성공적으로 업데이트 했습니다."

  }



}