package ru.gbuac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "compliance_with_legislation")
public class ComplianceWithLegislation extends BaseEntity {

    //-----Проблемы с адресом-----
    //Отсутствует адрес
    @Column(name = "address_issues_no_address", columnDefinition = "boolean default false")
    private Boolean addressIssuesNoAddress;

    //Неполный адрес
    @Column(name = "address_issues_incomplete", columnDefinition = "boolean default false")
    private Boolean addressIssuesIncomplete;

    //Некорректный адрес
    @Column(name = "address_issues_invalid", columnDefinition = "boolean default false")
    private Boolean addressIssuesInvalid;

    //Комментарий к проблемам с адресом
    @SafeHtml
    @Column(name = "comment_address_issues")
    @JsonInclude
    private String commentAddressIssues;

    //-----Проблемы с оформлением ЗПО-----
    //ЗУ с недействующими ЗПО
    @Column(name = "land_reg_inactive", columnDefinition = "boolean default false")
    private Boolean landRegInactive;

    //ЗУ с недействующими ЗПО в неразграниченной собственности
    @Column(name = "land_reg_inactive_un_ownership", columnDefinition = "boolean default false")
    private Boolean landRegInactiveUnOwnership;

    //ОКС на несформированном ЗУ
    @Column(name = "land_reg_build_at_not_formed_land", columnDefinition = "boolean default false")
    private Boolean landRegBuildAtNotFormedLand;

    //Комментарий к проблемам с ЗПО
    @SafeHtml
    @Column(name = "comment_land_reg")
    @JsonInclude
    private String commentLandReg;

    //-----Самовольная застройка-----
    //Несоответствие сведениям разрешительной документации
    @Column(name = "self_willed_build_doc_mismatch", columnDefinition = "boolean default false")
    private Boolean selfWilledBuildDocMismatch;

    //Комментарий к самовольной застройке
    @SafeHtml
    @Column(name = "comment_self_willed_build")
    @JsonInclude
    private String commentSelfWilledBuild;

    //-----Нецелевое использование-----
    //Несоответствие вывесок
    @Column(name = "misuse_sign_mismatch", columnDefinition = "boolean default false")
    private Boolean misuseSignMismatch;

    //Комментарий к нецелевому использованию
    @SafeHtml
    @Column(name = "comment_misuse_sign_mismatch")
    @JsonInclude
    private String commentMisuse;

    //--Самозахват
    //Заборы вне границ ЗУ
    @Column(name = "squatting_fences_outside_land_boundaries", columnDefinition = "boolean default false")
    private Boolean squattingFencesOutsideLandBoundaries;

    //ОКС на непредставленном ЗУ, неразграничеенной или городской собственности
    @Column(name = "squatting_build_on_unpres_land", columnDefinition = "boolean default false")
    private Boolean squattingBuildOnUnpresLand;

    //ОКС без прав
    @Column(name = "squatting_build_without_rights", columnDefinition = "boolean default false")
    private Boolean squattingBuildWithoutRights;

    //Комментарий к самозахвату
    @SafeHtml
    @Column(name = "comment_squatting")
    @JsonInclude
    private String commentSquatting;

    //-----Превышение сроков строительства-----
    @Column(name = "time_excess", columnDefinition = "boolean default false")
    private Boolean timeExcess;

    //Комментаий к превышению сроков строительства-----
    @SafeHtml
    @Column(name = "comment_time_excess")
    @JsonInclude
    private String commentTimeExcess;

    //-----Ненадлежащее содержание-----
    @Column(name = "inapp_maintenance", columnDefinition = "boolean default false")
    private Boolean inappMaintenance;

    //Комментарий к ненадлежащему содержанию
    @SafeHtml
    @Column(name = "comment_inapp_maintenance")
    @JsonInclude
    private String commentInappMaintenance;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_object_id", referencedColumnName = "id")
    private GeoObject geoObject;
}
