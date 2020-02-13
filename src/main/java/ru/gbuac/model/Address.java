package ru.gbuac.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address")
public class Address extends BaseEntity {
    @Column(name = "postcode")
    private Integer postcode;

    @JsonIgnore
    @Column(name = "default_postcode")
    private Integer defaultPostcode;

    @SafeHtml
    @Column(name = "region")
    private String region;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_region")
    private String defaultRegion;

    @SafeHtml
    @Column(name = "adm_district")
    private String admDistrict;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_adm_district")
    private String defaultAdmDistrict;

    @SafeHtml
    @Column(name = "district")
    private String district;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_district")
    private String defaultDistrict;

    @SafeHtml
    @Column(name = "locality_type")
    private String localityType;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_locality_type")
    private String defaultLocalityType;

    @SafeHtml
    @Column(name = "locality")
    private String locality;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_locality")
    private String defaultLocality;

    @SafeHtml
    @Column(name = "house_num")
    private String houseNum;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_house_num")
    private String defaultHouseNum;

    @SafeHtml
    @Column(name = "build_num")
    private String buildNum;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_build_num")
    private String defaultBuildNum;

    @SafeHtml
    @Column(name = "constr_num")
    private String consrNum;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_constr_num")
    private String defaultConsrNum;

    @SafeHtml
    @Column(name = "land_num")
    private String landNum;

    @JsonIgnore
    @SafeHtml
    @Column(name = "default_land_num")
    private String defaultLandNum;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "default_street_id", nullable = false)
    private Street defaultStreet;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_object_id", referencedColumnName = "id")
    private GeoObject geoObject;
}


