package ru.gbuac.model;

import com.vividsolutions.jts.geom.Polygon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "geo_object")
public class GeoObject extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "coordinates", columnDefinition = "geometry(Polygon,4326)")
    private Polygon coordinates;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tech_charact_id", referencedColumnName = "id")
    private TechCharact techCharacter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "build_assignment_id", referencedColumnName = "id")
    private BuildingAssignment buildingAssignment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cost_evaluation_id", referencedColumnName = "id")
    private CostEvaluation costEvaluationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cost_of_ownership_id", referencedColumnName = "id")
    private CostOfOwnership costOfOwnership;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compliance_with_legislation_id", referencedColumnName = "id")
    private ComplianceWithLegislation complianceWithLegislation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_revenues_id", referencedColumnName = "id")
    private BudgetRevenues budgetRevenues;
}
