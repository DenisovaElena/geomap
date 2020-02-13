package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.ComplianceWithLegislation;

public interface ComplianceWithLegislationRepository extends JpaRepository<ComplianceWithLegislation, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.addressIssuesNoAddress=:status, c.commentAddressIssues=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setAddressIssuesNoAddress(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.addressIssuesIncomplete=:status, c.commentAddressIssues=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setAddressIssuesIncomplete(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.addressIssuesInvalid=:status, c.commentAddressIssues=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setAddressIssuesInvalid(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.landRegInactive=:status, c.commentLandReg=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setLandRegInactive(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.landRegInactiveUnOwnership=:status, c.commentLandReg=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setLandRegInactiveUnOwnership(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.landRegBuildAtNotFormedLand=:status, c.commentLandReg=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setLandRegBuildAtNotFormedLand(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.selfWilledBuildDocMismatch=:status, c.commentSelfWilledBuild=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setSelfWilledBuildDocMismatch(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.misuseSignMismatch=:status, c.commentMisuse=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setMisuseSignMismatch(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.squattingFencesOutsideLandBoundaries=:status, c.commentSquatting=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setSquattingFencesOutsideLandBoundaries(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.squattingBuildOnUnpresLand=:status, c.commentSquatting=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setSquattingBuildOnUnpresLand(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.squattingBuildWithoutRights=:status, c.commentSquatting=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setSquattingBuildWithoutRights(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.timeExcess=:status, c.commentTimeExcess=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setTimeExcess(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);

    @Transactional
    @Modifying
    @Query("UPDATE ComplianceWithLegislation c SET c.inappMaintenance=:status, c.commentInappMaintenance=:statusComment WHERE c.geoObject.id=:geoObjectId")
    void setInappMaintenance(@Param("geoObjectId") int geoObjectId, @Param("status") boolean status, @Param("statusComment") String statusComment);
}
