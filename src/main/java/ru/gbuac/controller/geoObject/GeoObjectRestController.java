package ru.gbuac.controller.geoObject;

import com.vividsolutions.jts.io.ParseException;
import javassist.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.model.GeoObject;
import ru.gbuac.model.ProblemType;
import ru.gbuac.to.GeoObjectTo;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = GeoObjectRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class GeoObjectRestController extends AbstractGeoObjectRestController {
    public static final String REST_URL = "/rest/profile/geoObjects";

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public GeoObject updateOrCreate(@Valid @RequestBody GeoObject geoObject) throws NotFoundException {
        if (geoObject.isNew()) {
            return super.create(geoObject);
        } else {
            return super.update(geoObject, geoObject.getId());
        }
    }

    @Override
    @GetMapping(value = "/getByCoordinates")
        public GeoObject getByCoordinates(@RequestParam("longitude") double longitude,
                                          @RequestParam("latitude") double latitude) throws ParseException {
            return super.getByCoordinates(longitude, latitude);
    }

    @Override
    @GetMapping(value = "/get")
    public List<GeoObjectTo> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/get/{id}")
    public GeoObject get(@PathVariable("id") int id) throws NotFoundException {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/getAlgorithmProposals/{id}")
    public GeoObject getAlgorithmProposals(@PathVariable("id") int id, @RequestParam("problemType") String problemType) throws NotFoundException {
        return super.getAlgorithmProposals(id, problemType);
    }

    @Override
    @GetMapping(value = "/getAllHasProblem")
    public List<GeoObjectTo> getAllHasProblem(@RequestParam("problemType") String problemType) {
        return super.getAllHasProblem(problemType);
    }
}
