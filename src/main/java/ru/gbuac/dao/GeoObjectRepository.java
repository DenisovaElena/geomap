package ru.gbuac.dao;

import com.vividsolutions.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.GeoObject;
import java.util.List;

@Transactional(readOnly = true)
public interface GeoObjectRepository extends JpaRepository<GeoObject, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM GeoObject g WHERE g.id =:id ")
    int delete(@Param("id") int id);

    @Query("SELECT max(g) FROM GeoObject g WHERE WITHIN(:point, g.coordinates) = true")
    GeoObject getByCoordinates(@Param("point")Geometry point);

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.addressIssuesNoAddress=true")
    List<GeoObject> getAllHasProblemAddressIssuesNoAddress();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.addressIssuesIncomplete=true")
    List<GeoObject> getAllHasProblemAddressIssuesIncomplete();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.addressIssuesInvalid=true")
    List<GeoObject> getAllHasProblemAddressIssuesInvalid();

    @Query("SELECT g FROM GeoObject g " +
            "WHERE g.complianceWithLegislation.addressIssuesNoAddress=true OR g.complianceWithLegislation.addressIssuesIncomplete=true " +
            "OR g.complianceWithLegislation.addressIssuesInvalid=true")
    List<GeoObject> getAllHasProblemAddressIssues();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.landRegInactive=true")
    List<GeoObject> getAllHasProblemLandRegInactive();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.landRegInactiveUnOwnership=true")
    List<GeoObject> getAllHasProblemLandRegInactiveUnOwnership();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.landRegBuildAtNotFormedLand=true")
    List<GeoObject> getAllHasProblemLandRegBuildAtNotFormedLand();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.landRegInactive=true " +
            "OR g.complianceWithLegislation.landRegInactiveUnOwnership=true " +
            "OR g.complianceWithLegislation.landRegBuildAtNotFormedLand=true")
    List<GeoObject> getAllHasProblemLandReg();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.selfWilledBuildDocMismatch=true")
    List<GeoObject> getAllHasProblemSelfWilledBuildDocMismatch();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.misuseSignMismatch=true")
    List<GeoObject> getAllHasProblemMisuseSignMismatch();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.squattingFencesOutsideLandBoundaries=true")
    List<GeoObject> getAllHasProblemSquattingFencesOutsideLandBoundaries();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.squattingBuildOnUnpresLand=true")
    List<GeoObject> getAllHasProblemSquattingBuildOnUnpresLand();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.squattingBuildWithoutRights=true")
    List<GeoObject> getAllHasProblemSquattingBuildWithoutRights();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.squattingFencesOutsideLandBoundaries=true " +
            "OR g.complianceWithLegislation.squattingBuildOnUnpresLand=true " +
            "OR g.complianceWithLegislation.squattingBuildWithoutRights=true")
    List<GeoObject> getAllHasProblemSquatting();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.timeExcess=true")
    List<GeoObject> getAllHasProblemTimeExcess();

    @Query("SELECT g FROM GeoObject g WHERE g.complianceWithLegislation.inappMaintenance=true")
    List<GeoObject> getAllHasProblemInappMaintenance();
}