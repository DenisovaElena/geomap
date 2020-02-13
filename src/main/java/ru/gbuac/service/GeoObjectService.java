package ru.gbuac.service;

import com.vividsolutions.jts.io.ParseException;
import javassist.NotFoundException;
import ru.gbuac.model.GeoObject;
import ru.gbuac.to.GeoObjectTo;

import java.util.List;

public interface GeoObjectService {

    GeoObject get(int id) throws NotFoundException;

    List<GeoObjectTo> getAll();

    GeoObject save(GeoObject geoObject);

    GeoObject update(GeoObject geoObject, int id) throws NotFoundException;

    GeoObject getByCoordinates(double longitude, double latitude) throws ParseException;

    void delete(int id) throws NotFoundException;

    GeoObject getAlgorithmProposals(int id, String problemType) throws NotFoundException;

    List<GeoObjectTo> getAllHasProblem(String problemType);
}
