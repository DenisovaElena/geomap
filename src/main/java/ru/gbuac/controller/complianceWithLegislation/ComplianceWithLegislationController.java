package ru.gbuac.controller.complianceWithLegislation;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = ComplianceWithLegislationController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ComplianceWithLegislationController extends AbstractComplianceWithLegislationController {
    public static final String REST_URL = "/rest/profile/geoObjects/{geoObjectId}";

    @Override
    @PostMapping(value = "/setProblem")
    public void setProblem(@PathVariable("geoObjectId") int geoObjectId,
                           @RequestParam("problemType") String problemType,
                           @RequestParam("status") boolean status,
                           @RequestParam("statusComment") String statusComment) {
        super.setProblem(geoObjectId, problemType, status, statusComment);
    }
}