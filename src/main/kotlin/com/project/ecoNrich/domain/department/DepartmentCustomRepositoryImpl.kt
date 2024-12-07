package com.project.ecoNrich.domain.department

import com.project.ecoNrich.domain.country.QCountry
import com.project.ecoNrich.domain.department.rqrs.DepartmentDto
import com.project.ecoNrich.domain.employee.entity.QJobHistory
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import com.project.ecoNrich.domain.job.QJob
import com.project.ecoNrich.domain.location.QLocation
import com.project.ecoNrich.domain.region.QRegion
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class DepartmentCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : DepartmentCustomRepository {

  private val department: QDepartment = QDepartment.department
  private val location: QLocation = QLocation.location
  private val country: QCountry = QCountry.country
  private val region: QRegion = QRegion.region

  override fun searchDepartment(departmentId: Long?): List<DepartmentDto> {
    return queryFactory
        .select(
            Projections.fields(
                DepartmentDto::class.java,
                department.departmentId,
                department.departmentName,
                department.location.locationId,
                location.streetAddress,
                location.postalCode,
                location.city,
                location.stateProvince,
                location.country.countryId,
                country.countryName,
                region.regionName
            )
        )
        .from(department)
        .leftJoin(location).on(department.location.eq(location))
        .leftJoin(country).on(location.country.eq(country))
        .leftJoin(region).on(country.region.eq(region))
        .where(departmentId?.let { department.departmentId.eq(it) })
        .fetch()

  }
}