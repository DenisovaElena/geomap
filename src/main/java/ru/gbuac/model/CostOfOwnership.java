package ru.gbuac.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cost_of_ownership")
public class CostOfOwnership extends BaseEntity {
    @Column(name = "hot_water")
    private Integer hotWater;

    @Column(name = "cold_water")
    private Integer coldWater;

    @Column(name = "water_disp")
    private Integer waterDisp;

    @Column(name = "heat_sys")
    private Integer heatSys;

    @Column(name = "electrosupply")
    private Integer electrosupply;

    @Column(name = "gas_supply")
    private Integer gasSupply;

    @Column(name = "utility_costs")
    private Integer utilityCosts;

    @Column(name = "wealth_tax")
    private Integer wealthTax;

    @Column(name = "land_tax")
    private Integer landTax;

    @Column(name = "rent")
    private Integer rent;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_object_id", referencedColumnName = "id")
    private GeoObject geoObject;

  }
