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
@Table(name = "cost_evaluation")
public class CostEvaluation extends BaseEntity {
    @Column(name = "av_cad_val_build")
    private Integer adCadValRoom;

    @Column(name = "av_cad_val_land")
    private Integer avCadValLand;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_object_id", referencedColumnName = "id")
    private GeoObject geoObject;
}
