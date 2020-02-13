DROP TABLE IF EXISTS tech_charact;

DROP TABLE IF EXISTS address;

DROP TABLE IF EXISTS street;

DROP TABLE IF EXISTS street_type;

DROP TABLE IF EXISTS building_assignment;

DROP TABLE IF EXISTS owner;

DROP TABLE IF EXISTS cost_evaluation;

DROP TABLE IF EXISTS cost_of_ownership;

DROP TABLE IF EXISTS budget_revenues;

DROP TABLE IF EXISTS compliance_with_legislation;

DROP TABLE IF EXISTS geo_object;


DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE geo_object
(
    id                     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name                   VARCHAR NOT NULL,
    coordinates            public.GEOMETRY NOT NULL,
    tech_charact_id        INTEGER NOT NULL,
    address_id             INTEGER NOT NULL,
    build_assignment_id    INTEGER NOT NULL,
    owner_id               INTEGER NOT NULL,
    cost_evaluation_id     INTEGER NOT NULL,
    cost_of_ownership_id   INTEGER NOT NULL,
    compliance_with_legislation_id INTEGER NOT NULL,
    budget_revenues_id     INTEGER NOT NULL
);

CREATE TABLE tech_charact
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    area          VARCHAR NOT NULL,
    floor_num     VARCHAR,
    geo_object_id INTEGER NOT NULL,
    UNIQUE(geo_object_id),
    FOREIGN KEY (geo_object_id) REFERENCES geo_object (id) ON DELETE CASCADE
);

CREATE TABLE street_type
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name              VARCHAR
);

CREATE TABLE street
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name              VARCHAR                     ,
    coordinates       public.GEOMETRY NOT NULL,
    street_type_id    INTEGER NOT NULL,
    FOREIGN KEY (street_type_id) REFERENCES street_type (id) ON DELETE CASCADE
);

CREATE TABLE address
(
    id                      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    postcode                VARCHAR                 ,
    region                  VARCHAR                 ,
    adm_district            VARCHAR                 ,
    district                VARCHAR                 ,
    locality_type           VARCHAR                 ,
    locality                VARCHAR                 ,
    street                  VARCHAR                 ,
    house_num               VARCHAR                 ,
    build_num               VARCHAR                 ,
    constr_num              VARCHAR                 ,
    land_num                VARCHAR                 ,
    street_id               INTEGER NOT NULL,
    default_postcode        VARCHAR                 ,
    default_region          VARCHAR                 ,
    default_adm_district    VARCHAR                 ,
    default_district        VARCHAR                 ,
    default_locality_type   VARCHAR                 ,
    default_locality        VARCHAR                 ,
    default_street_type     VARCHAR                 ,
    default_street          VARCHAR                 ,
    default_house_num       VARCHAR                 ,
    default_build_num       VARCHAR                 ,
    default_constr_num      VARCHAR                 ,
    default_land_num        VARCHAR                 ,
    default_street_id       INTEGER NOT NULL,
    geo_object_id           INTEGER NOT NULL,
    UNIQUE(geo_object_id),
    FOREIGN KEY (geo_object_id) REFERENCES geo_object (id) ON DELETE CASCADE,
    FOREIGN KEY (street_id) REFERENCES street (id) ON DELETE CASCADE
);

CREATE TABLE building_assignment
(
    id                 INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    assignment      VARCHAR,
    geo_object_id   INTEGER NOT NULL,
    UNIQUE(geo_object_id),
    FOREIGN KEY (geo_object_id) REFERENCES geo_object (id) ON DELETE CASCADE
);

CREATE TABLE owner
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    permis_owner             VARCHAR                 NOT NULL,
    geo_object_id   INTEGER NOT NULL,
    UNIQUE(geo_object_id),
    FOREIGN KEY (geo_object_id) REFERENCES geo_object (id) ON DELETE CASCADE
);

CREATE TABLE cost_evaluation
(
    id                      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    av_cad_val_build            INTEGER                      NOT NULL,
    av_cad_val_land                INTEGER                  NOT NULL,
    geo_object_id   INTEGER NOT NULL,
    UNIQUE(geo_object_id),
    FOREIGN KEY (geo_object_id) REFERENCES geo_object (id) ON DELETE CASCADE
);


CREATE TABLE cost_of_ownership
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    hot_water     INTEGER NOT NULL,
    cold_water    INTEGER NOT NULL,
    water_disp    INTEGER NOT NULL,
    heat_sys      INTEGER NOT NULL,
    electrosupply INTEGER NOT NULL,
    gas_supply    INTEGER,
    utility_costs INTEGER,
    wealth_tax    INTEGER,
    land_tax      INTEGER,
    rent          INTEGER,
    geo_object_id   INTEGER NOT NULL,
    UNIQUE(geo_object_id),
    FOREIGN KEY (geo_object_id) REFERENCES geo_object (id) ON DELETE CASCADE
);

CREATE TABLE budget_revenues
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    wealth_tax       VARCHAR                ,
    wealth_tax_accrued       VARCHAR                ,
    wealth_tax_received       VARCHAR                ,
    wealth_tax_debt         VARCHAR         ,
    land_tax     VARCHAR                ,
    land_tax_accrued      VARCHAR       ,
    land_tax_received     VARCHAR       ,
    land_tax_debt     VARCHAR       ,
    rent            VARCHAR         ,
    rent_accrued        VARCHAR         ,
    rent_received     VARCHAR               ,
    rent_debt           VARCHAR         ,
    area_owners_objects     VARCHAR                 ,
    area_own_obj_ndfl    VARCHAR                 ,
    area_own_obj_ndfl_chan_own  VARCHAR         ,
    ndfl_sum VARCHAR,
    geo_object_id   INTEGER NOT NULL,
    UNIQUE(geo_object_id),
    FOREIGN KEY (geo_object_id) REFERENCES geo_object (id) ON DELETE CASCADE
);

CREATE TABLE compliance_with_legislation
(
    id                                          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    address_issues_no_address		            BOOLEAN		DEFAULT FALSE,
    address_issues_incomplete	    	        BOOLEAN		DEFAULT FALSE,
    address_issues_invalid			            BOOLEAN		DEFAULT FALSE,
    comment_address_issues			            VARCHAR			     ,
    land_reg_inactive			                BOOLEAN		DEFAULT FALSE,
    land_reg_inactive_un_ownership	            BOOLEAN		DEFAULT FALSE,
    land_reg_build_at_not_formed_land	        BOOLEAN		DEFAULT FALSE,
    comment_land_reg			                VARCHAR			     ,
    self_willed_build_doc_mismatch		        BOOLEAN		DEFAULT FALSE,
    comment_self_willed_build		            VARCHAR			     ,
    misuse_sign_mismatch			            BOOLEAN		DEFAULT FALSE,
    comment_misuse_sign_mismatch		        VARCHAR			     ,
    squatting_fences_outside_land_boundaries	BOOLEAN		DEFAULT FALSE,
    squatting_build_on_unpres_land		        BOOLEAN		DEFAULT FALSE,
    squatting_build_without_rights		        BOOLEAN		DEFAULT FALSE,
    comment_squatting			                VARCHAR			     ,
    time_excess				                    BOOLEAN		DEFAULT FALSE,
    comment_time_excess			                VARCHAR			     ,
    inapp_maintenance			                BOOLEAN		DEFAULT FALSE,
    comment_inapp_maintenance		            VARCHAR			     ,
    geo_object_id                               INTEGER NOT NULL,
    UNIQUE(geo_object_id),
    FOREIGN KEY (geo_object_id) REFERENCES geo_object (id) ON DELETE CASCADE
);