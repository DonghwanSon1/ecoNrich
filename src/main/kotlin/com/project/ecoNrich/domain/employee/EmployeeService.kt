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
import java.math.RoundingMode
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
  @Transactional
  fun updateEmployeeSalary(departmentId: Long, rate: Double): String {

    // 부서에 속한 사원들을 조회해서 가져오고, 없을 시 존재하지 않다는 메시지를 응답한다.
    // (부서는 존재하지만 사원이 없을 수도 있기 때문에 Exception 이 아닌 메시지로 응답한다.)
    val employeeList: List<Employee> = employeeRepository.findByDepartmentDepartmentId(departmentId)
        .takeIf { it.isNotEmpty() } ?: return "해당 부서에는 사원들이 존재하지 않습니다."

    // 엔티티에서 val -> var 로 변경하여 JPA 영속성을 이용하여 Update 할 수 있도록 한다.
    employeeList.forEach { it.salary = it.salary!!.multiply(BigDecimal.valueOf(rate))
        .setScale(2, RoundingMode.HALF_UP) }

    return "해당 부서의 사원들을 해당 비율로 급여 인상하였습니다."
  }



}