package ru.gbuac.to;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class GeoObjectTo extends BaseTo {
    private String name;

    private Polygon coordinates;

    private Point centerCoordinates;

    private String address;

    public GeoObjectTo(Integer id, String name, Polygon coordinates, Point centerCoordinates, String address) {
        super(id);
        this.name = name;
        this.coordinates = coordinates;
        this.centerCoordinates = centerCoordinates;
        this.address = address;
    }
}
