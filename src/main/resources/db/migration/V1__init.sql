CREATE TABLE category
(
    id              BIGINT NOT NULL AUTO_INCREMENT,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    name            VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE joined_table_instructor
(
    user_id          BIGINT NOT NULL,
    favorite_student VARCHAR(255) NULL,
    CONSTRAINT pk_joined_table_instructor PRIMARY KEY (user_id)
);

CREATE TABLE joined_table_mentor
(
    user_id BIGINT NOT NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_joined_table_mentor PRIMARY KEY (user_id)
);

CREATE TABLE joined_table_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_joined_table_user PRIMARY KEY (id)
);

CREATE TABLE ms_instructor
(
    id               BIGINT NOT NULL,
    name             VARCHAR(255) NULL,
    email            VARCHAR(255) NULL,
    favorite_student VARCHAR(255) NULL,
    CONSTRAINT pk_ms_instructor PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT NOT NULL AUTO_INCREMENT,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    title           VARCHAR(255) NULL,
    price DOUBLE NULL,
    category_id     BIGINT NULL,
    `description`   VARCHAR(255) NULL,
    image_url       VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id               BIGINT NOT NULL,
    name             VARCHAR(255) NULL,
    email            VARCHAR(255) NULL,
    favorite_student VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

CREATE TABLE user_single_table
(
    id               BIGINT NOT NULL,
    user_type        INT NULL,
    name             VARCHAR(255) NULL,
    email            VARCHAR(255) NULL,
    favorite_student VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_user_single_table PRIMARY KEY (id)
);

ALTER TABLE joined_table_instructor
    ADD CONSTRAINT FK_JOINED_TABLE_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES joined_table_user (id);

ALTER TABLE joined_table_mentor
    ADD CONSTRAINT FK_JOINED_TABLE_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES joined_table_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);