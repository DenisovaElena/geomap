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
@Table(name = "budget_revenues")
public class BudgetRevenues extends BaseEntity {
    @SafeHtml
    @Column(name = "wealth_tax")
    private String wealthTax;

    @SafeHtml
    @Column(name = "wealth_tax_accrued")
    private String wealthTaxAccrued;

    @SafeHtml
    @Column(name = "wealth_tax_received")
    private String wealthTaxRecieved;

    @SafeHtml
    @Column(name = "wealth_tax_debt")
    private String wealthTaxDebt;

    @SafeHtml
    @Column(name = "land_tax")
    private String landTax;

    @SafeHtml
    @Column(name = "land_tax_accrued")
    private String landTaxAccrued;

    @SafeHtml
    @Column(name = "land_tax_received")
    private String landTaxReceived;

    @SafeHtml
    @Column(name = "land_tax_debt")
    private String landTaxDebt;

    @SafeHtml
    @Column(name = "rent")
    private String rent;

    @SafeHtml
    @Column(name = "rent_accrued")
    private String rentAccrued;

    @SafeHtml
    @Column(name = "rent_received")
    private String rentReceived;

    @SafeHtml
    @Column(name = "rent_debt")
    private String rentDebt;

    @SafeHtml
    @Column(name = "area_owners_objects")
    private String areaOwnersObjects;

    @SafeHtml
    @Column(name = "area_own_obj_ndfl")
    private String areaOwnObjNdfl;

    @SafeHtml
    @Column(name = "area_own_obj_ndfl_chan_own")
    private String areaOwnObjNdflChanOwn;

    @SafeHtml
    @Column(name = "ndfl_sum")
    private String ndfl;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_object_id", referencedColumnName = "id")
    private GeoObject geoObject;

}

