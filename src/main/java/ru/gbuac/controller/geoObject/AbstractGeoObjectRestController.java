package ru.gbuac.controller.geoObject;

import com.vividsolutions.jts.io.ParseException;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.model.GeoObject;
import ru.gbuac.model.ProblemType;
import ru.gbuac.service.GeoObjectService;
import ru.gbuac.to.GeoObjectTo;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractGeoObjectRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected GeoObjectService geoObjectService;

    public List<GeoObjectTo> getAll() {
        LOG.info("getAll");
        return geoObjectService.getAll();
    }

    public GeoObject create(GeoObject geoObject) {
        LOG.info("create " + geoObject);
        checkNew(geoObject);
        return geoObjectService.save(geoObject);
    }

    public GeoObject update(GeoObject geoObject, int id) throws NotFoundException {
        LOG.info("update " + geoObject);
        assureIdConsistent(geoObject, id);
        return geoObjectService.update(geoObject, id);
    }

    public void delete(int id) throws NotFoundException {
        LOG.info("delete " + id);
        geoObjectService.delete(id);
    }

    public GeoObject getByCoordinates(double longitude, double latitude) throws ParseException {
        return geoObjectService.getByCoordinates(longitude, latitude);
    }

    public GeoObject get(int id) throws NotFoundException {
        LOG.info("get " + id);
        return geoObjectService.get(id);
    }

    public GeoObject getAlgorithmProposals(int id, String problemTypeId) throws NotFoundException {
        LOG.info("get " + id, " problemType = " + ProblemType.valueOf(problemTypeId));
        return geoObjectService.getAlgorithmProposals(id, problemTypeId);
    }

    public List<GeoObjectTo> getAllHasProblem(String problemType) {
        LOG.info("getAllHasProblem " + ProblemType.valueOf(problemType));
        return geoObjectService.getAllHasProblem(problemType);
    }


}
