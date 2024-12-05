package com.project.ecoNrich.domain.region

import javax.persistence.*

@Entity
@Table(name = "regions")
class Region(
    @Id
    @Column(name = "region_id")
    val regionId: Int,

    @Column(name = "region_name")
    val regionName: String? = null

) {
}