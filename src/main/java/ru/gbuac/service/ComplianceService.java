package ru.gbuac.service;

import javassist.NotFoundException;
import ru.gbuac.model.GeoObject;

import java.util.List;

public interface ComplianceService {
    void setProblem(int geoObjectId, String problemType, boolean status, String statusComment);
}
