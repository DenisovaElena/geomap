package ru.gbuac.util;

import ru.gbuac.model.GeoObject;
import ru.gbuac.to.GeoObjectTo;

import java.util.ArrayList;
import java.util.List;

public class GeoObjectUtil {
    public GeoObjectUtil() {
    }

    public static GeoObjectTo asNewGeoObjectTo(GeoObject geoObject) {
        return new GeoObjectTo(geoObject.getId(), geoObject.getName(), geoObject.getCoordinates(),
                geoObject.getCoordinates().getCentroid(), null);
    }

    public static List<GeoObjectTo> asGeoObjectToList(List<GeoObject> geoObjects) {
        List<GeoObjectTo> geoObjectTos = new ArrayList<>();
        for (GeoObject geoObject : geoObjects) {
            geoObjectTos.add(asNewGeoObjectTo(geoObject));
        }
        return geoObjectTos;
    }
}
