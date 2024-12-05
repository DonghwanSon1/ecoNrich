package com.project.ecoNrich.domain.location

import com.project.ecoNrich.domain.country.Country
import javax.persistence.*

@Entity
@Table(name = "locations")
class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    val locationId: Int,

    @Column(name = "street_address")
    val streetAddress: String? = null,

    @Column(name = "postal_code")
    val postalCode: String? = null,

    @Column(name = "city")
    val city: String,

    @Column(name = "state_province")
    val stateProvince: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    val country: Country

) {
}