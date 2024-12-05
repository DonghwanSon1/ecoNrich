package com.project.ecoNrich.domain.country

import com.project.ecoNrich.domain.region.Region
import javax.persistence.*

@Entity
@Table(name = "countries")
class Country(
    @Id
    @Column(name = "country_id")
    val countryId: String,

    @Column(name = "country_name")
    val countryName: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    val region: Region

) {
}