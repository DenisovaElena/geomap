package ru.gbuac.model;

import com.vividsolutions.jts.geom.LineString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "street")
public class Street extends BaseEntity {
    @SafeHtml
    @Column(name = "name")
    private String name;

    @Column(name = "coordinates")
    private LineString coordinates;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "street_type_id", nullable = false)
    private StreetType streetType;
}
