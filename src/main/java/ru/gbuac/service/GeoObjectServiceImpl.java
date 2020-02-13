package ru.gbuac.service;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.dao.ComplianceWithLegislationRepository;
import ru.gbuac.dao.GeoObjectRepository;
import ru.gbuac.dao.StreetRepository;
import ru.gbuac.model.Address;
import ru.gbuac.model.GeoObject;
import ru.gbuac.model.ProblemType;
import ru.gbuac.model.Street;
import ru.gbuac.to.GeoObjectTo;
import java.util.List;
import java.util.Locale;
import static ru.gbuac.util.GeoObjectUtil.asGeoObjectToList;
import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class GeoObjectServiceImpl implements GeoObjectService {

    @Autowired
    private GeoObjectRepository geoObjectRepository;

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private ComplianceWithLegislationRepository  complianceWithLegislationRepository;

    @Override
    public List<GeoObjectTo> getAll() {
        return asGeoObjectToList(geoObjectRepository.findAll());
    }

    @Override
    public GeoObject save(GeoObject geoObject) {
        Assert.notNull(geoObject, "catalog must not be null");
        return geoObjectRepository.save(geoObject);
    }

    private void setDefaultValues(Address currentAddress, Address dbAddress) {
        currentAddress.setDefaultPostcode(dbAddress.getDefaultPostcode());
        currentAddress.setDefaultRegion(dbAddress.getDefaultRegion());
        currentAddress.setDefaultAdmDistrict(dbAddress.getDefaultAdmDistrict());
        currentAddress.setDefaultDistrict(dbAddress.getDefaultDistrict());
        currentAddress.setDefaultLocalityType(dbAddress.getDefaultLocalityType());
        currentAddress.setDefaultLocality(dbAddress.getDefaultLocality());
        currentAddress.setDefaultStreet(dbAddress.getDefaultStreet());
        currentAddress.setDefaultHouseNum(dbAddress.getDefaultHouseNum());
        currentAddress.setDefaultBuildNum(dbAddress.getDefaultBuildNum());
        currentAddress.setDefaultConsrNum(dbAddress.getDefaultConsrNum());
        currentAddress.setDefaultLandNum(dbAddress.getDefaultLandNum());
    }

    @Override
    public GeoObject update(GeoObject geoObject, int id) throws NotFoundException {
        Assert.notNull(geoObject, "catalog must not be null");
        GeoObject dbGeoObject = geoObjectRepository.findById(id).orElse(null);
        geoObject.setCoordinates(dbGeoObject.getCoordinates());
        geoObject.getBudgetRevenues().setGeoObject(geoObject);
        geoObject.getBuildingAssignment().setGeoObject(geoObject);
        geoObject.getComplianceWithLegislation().setGeoObject(geoObject);
        geoObject.getCostEvaluationId().setGeoObject(geoObject);
        geoObject.getCostOfOwnership().setGeoObject(geoObject);
        geoObject.getTechCharacter().setGeoObject(geoObject);
        geoObject.getOwner().setGeoObject(geoObject);
        geoObject.getAddress().setGeoObject(geoObject);
        Street street = streetRepository.findById(geoObject.getAddress().getStreet().getId()).orElse(null);
        setDefaultValues(geoObject.getAddress(), dbGeoObject.getAddress());
        geoObject.getAddress().setStreet(street);
        return checkNotFoundWithId(geoObjectRepository.save(geoObject), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Assert.notNull(id, "catalog must not be null");
        checkNotFoundWithId(geoObjectRepository.delete(id)!= 0, id);
    }

    private Geometry wktToGeometry(String wktPoint) throws ParseException {
        return new WKTReader().read(wktPoint);
    }

    @Override
    public GeoObject getByCoordinates(double longitude, double latitude) throws ParseException {
        Geometry point = wktToGeometry(String.format(Locale.US,"POINT(%f %f)", longitude, latitude));
        return geoObjectRepository.getByCoordinates(point);
    }

    @Override
    public GeoObject get(int id) throws NotFoundException {
        return checkNotFoundWithId(geoObjectRepository.findById(id).orElse(null), id);
    }

    @Override
    public GeoObject getAlgorithmProposals(int id, String problemType) throws NotFoundException {
        GeoObject geoObject = checkNotFoundWithId(geoObjectRepository.findById(id).orElse(null), id);
        Address address = geoObject.getAddress();
        switch (ProblemType.valueOf(problemType)) {
            case addressIssues:
            case addressIssuesNoAddress:
            case addressIssuesIncomplete:
                if (address.getPostcode() == null) {
                    address.setPostcode(address.getDefaultPostcode());
                }
                if (address.getRegion() == null || address.getRegion().equals("-")) {
                    address.setRegion(address.getDefaultRegion());
                }
                if (address.getAdmDistrict() == null || address.getAdmDistrict().equals("-")) {
                    address.setAdmDistrict(address.getDefaultAdmDistrict());
                }
                if (address.getDistrict() == null || address.getDistrict().equals("-")) {
                    address.setDistrict(address.getDefaultDistrict());
                }
                if (address.getLocalityType() == null || address.getLocalityType().equals("-")) {
                    address.setLocalityType(address.getDefaultLocalityType());
                }
                if (address.getLocality() == null || address.getLocality().equals("-")) {
                    address.setLocality(address.getDefaultLocality());
                }
                if (address.getStreet() == null) {
                    address.setStreet(address.getDefaultStreet());
                }
                if (address.getHouseNum() == null || address.getHouseNum().equals("-")) {
                    address.setHouseNum("{" + address.getDefaultHouseNum() + "}");
                }
                if (address.getBuildNum() == null || address.getBuildNum().equals("-")) {
                    address.setBuildNum(address.getDefaultBuildNum());
                }
                if (address.getConsrNum() == null || address.getConsrNum().equals("-")) {
                    address.setConsrNum(address.getConsrNum());
                }
                geoObject.setAddress(address);
                break;
            case addressIssuesInvalid:
                address.setPostcode(address.getDefaultPostcode());
                address.setRegion(address.getDefaultRegion());
                address.setAdmDistrict(address.getDefaultAdmDistrict());
                address.setDistrict(address.getDefaultDistrict());
                address.setLocalityType(address.getDefaultLocalityType());
                address.setLocality(address.getDefaultLocality());
                address.setStreet(address.getDefaultStreet());
                address.setHouseNum(address.getDefaultHouseNum());
                address.setBuildNum(address.getDefaultBuildNum());
                address.setConsrNum(address.getConsrNum());
                geoObject.setAddress(address);
                break;
            case landReg:
            case landRegInactive:
            case landRegInactiveUnOwnership:
            case landRegBuildAtNotFormedLand:
            case selfWilled:
            case selfWilledBuildDocMismatch:
            case misuse:
            case misuseSignMismatch:
            case squatting:
            case squattingFencesOutsideLandBoundaries:
            case squattingBuildOnUnpresLand:
            case squattingBuildWithoutRights:
            case timeExcess:
            case inappMaintenance:
        }
        return geoObject;
    }

    @Override
    public List<GeoObjectTo> getAllHasProblem(String problemType) {
        switch (ProblemType.valueOf(problemType)) {
            case addressIssues:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemAddressIssues());
            case addressIssuesNoAddress:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemAddressIssuesNoAddress());
            case addressIssuesIncomplete:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemAddressIssuesIncomplete());
            case addressIssuesInvalid:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemAddressIssuesInvalid());
            case landReg:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemLandReg());
            case landRegInactive:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemLandRegInactive());
            case landRegInactiveUnOwnership:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemLandRegInactiveUnOwnership());
            case landRegBuildAtNotFormedLand:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemLandRegBuildAtNotFormedLand());
            case selfWilled:
            case selfWilledBuildDocMismatch:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemSelfWilledBuildDocMismatch());
            case misuse:
            case misuseSignMismatch:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemMisuseSignMismatch());
            case squatting:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemSquatting());
            case squattingFencesOutsideLandBoundaries:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemSquattingFencesOutsideLandBoundaries());
            case squattingBuildOnUnpresLand:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemSquattingBuildOnUnpresLand());
            case squattingBuildWithoutRights:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemSquattingBuildWithoutRights());
            case timeExcess:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemTimeExcess());
            case inappMaintenance:
                return asGeoObjectToList(geoObjectRepository.getAllHasProblemInappMaintenance());
            default:
                return getAll();
        }
    }
}
