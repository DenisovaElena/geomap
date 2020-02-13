package ru.gbuac.controller.complianceWithLegislation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.service.ComplianceService;

public abstract class AbstractComplianceWithLegislationController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected ComplianceService complianceService;

    public void setProblem(int geoObjectId, String problemType, boolean status, String statusComment) {
        complianceService.setProblem(geoObjectId, problemType, status, statusComment);
    }
}
