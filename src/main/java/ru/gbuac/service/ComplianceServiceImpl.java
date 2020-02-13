package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gbuac.dao.ComplianceWithLegislationRepository;
import ru.gbuac.model.ProblemType;

@Service
public class ComplianceServiceImpl implements ComplianceService {

    @Autowired
    private ComplianceWithLegislationRepository complianceWithLegislationRepository;

    @Override
    public void setProblem(int geoObjectId, String problemType, boolean status, String statusComment) {
        switch (ProblemType.valueOf(problemType)) {
            case addressIssuesNoAddress:
                complianceWithLegislationRepository.setAddressIssuesNoAddress(geoObjectId, status, statusComment);
                break;
            case addressIssuesIncomplete:
                complianceWithLegislationRepository.setAddressIssuesIncomplete(geoObjectId, status, statusComment);
                break;
            case addressIssuesInvalid:
                complianceWithLegislationRepository.setAddressIssuesInvalid(geoObjectId, status, statusComment);
                break;
            case landRegInactive:
                complianceWithLegislationRepository.setLandRegInactive(geoObjectId, status, statusComment);
                break;
            case landRegInactiveUnOwnership:
                complianceWithLegislationRepository.setLandRegInactiveUnOwnership(geoObjectId, status, statusComment);
                break;
            case landRegBuildAtNotFormedLand:
                complianceWithLegislationRepository.setLandRegBuildAtNotFormedLand(geoObjectId, status, statusComment);
                break;
            case selfWilledBuildDocMismatch:
                complianceWithLegislationRepository.setSelfWilledBuildDocMismatch(geoObjectId, status, statusComment);
                break;
            case misuseSignMismatch:
                complianceWithLegislationRepository.setMisuseSignMismatch(geoObjectId, status, statusComment);
            case squattingFencesOutsideLandBoundaries:
                complianceWithLegislationRepository.setSquattingFencesOutsideLandBoundaries(geoObjectId, status, statusComment);
            case squattingBuildOnUnpresLand:
                complianceWithLegislationRepository.setSquattingBuildOnUnpresLand(geoObjectId, status, statusComment);
            case squattingBuildWithoutRights:
                complianceWithLegislationRepository.setSquattingBuildWithoutRights(geoObjectId, status, statusComment);
            case timeExcess:
                complianceWithLegislationRepository.setTimeExcess(geoObjectId, status, statusComment);
            case inappMaintenance:
                complianceWithLegislationRepository.setInappMaintenance(geoObjectId, status, statusComment);
        }
    }
}
