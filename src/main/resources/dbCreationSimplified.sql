



-- auto-generated definition
CREATE TABLE user
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  first_name  VARCHAR(25) NULL,
  last_name   VARCHAR(25) NULL,
  email       VARCHAR(30) NULL,
  password    VARCHAR(30) NULL,
  li_password VARCHAR(30) NULL,
  CONSTRAINT user_id_uindex
  UNIQUE (id)
);

-- auto-generated definition
CREATE TABLE connections
(
  id                 INT AUTO_INCREMENT
    PRIMARY KEY,
  user_id            INT         NULL,
  linkedin_id        INT         NULL,
  first_name         VARCHAR(30) NULL,
  last_name          VARCHAR(30) NULL,
  number_connections INT         NULL,
  is_updated         TINYINT(1)  NULL,
  CONSTRAINT connections_connection_id_uindex
  UNIQUE (id),
  CONSTRAINT FK_connection_user_id
  FOREIGN KEY (user_id) REFERENCES user (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
CREATE INDEX FK_connection_user_id
  ON connections (user_id);

-- auto-generated definition
CREATE TABLE connection_updates
(
  id               INT          NOT NULL
    PRIMARY KEY,
  connection_id    INT          NULL,
  relationship     VARCHAR(50)  NULL,
  shared_interests VARCHAR(255) NULL,
  background       VARCHAR(255) NULL,
  notes            TEXT         NULL,
  CONSTRAINT FK_updates_connection_id
  FOREIGN KEY (connection_id) REFERENCES connections (id)

);
CREATE INDEX FK_updates_connection_id
  ON connection_updates (connection_id);

-- auto-generated definition
CREATE TABLE action_items
(
  id               INT AUTO_INCREMENT
    PRIMARY KEY,
  connection_id    INT         NOT NULL,
  user_id          INT         NOT NULL,
  action_item_name VARCHAR(30) NULL,
  date_created     DATE        NULL,
  status           VARCHAR(15) NULL,
  is_complete      TINYINT(1)  NULL,
  date_completed   DATE        NULL,
  CONSTRAINT action_items_id_uindex
  UNIQUE (id),
  CONSTRAINT FK_item_connectionid
  FOREIGN KEY (connection_id) REFERENCES connections (id),
  CONSTRAINT FK_item_user_id
  FOREIGN KEY (user_id) REFERENCES user (id)
);
CREATE INDEX FK_item_connectionid
  ON action_items (connections_id);
CREATE INDEX FK_item_user_id
  ON action_items (user_id);


-- auto-generated definition
CREATE TABLE connection_detail
(
  id            INT          NOT NULL
    PRIMARY KEY,
  connection_id INT          NOT NULL,
  headline      VARCHAR(255) NULL,
  location      VARCHAR(30)  NULL,
  industry      VARCHAR(30)  NULL,
  summary       TEXT         NULL,
  specialties   TEXT         NULL,
  profile       VARCHAR(50)  NULL,
  CONSTRAINT FK_detail_connection_id
  FOREIGN KEY (connection_id) REFERENCES connections (id)
);
CREATE INDEX FK_detail_connection_id
  ON connection_detail (connection_id);

-- auto-generated definition
CREATE TABLE connection_job
(
  id              INT AUTO_INCREMENT
    PRIMARY KEY,
  connection_id   INT         NULL,
  job_name        VARCHAR(30) NULL,
  company_name    VARCHAR(30) NULL,
  job_start       DATE        NULL,
  job_end         DATE        NULL,
  job_description TEXT        NULL,
  CONSTRAINT connection_job_id_uindex
  UNIQUE (id),
  CONSTRAINT FK_job_connection_id
  FOREIGN KEY (connection_id) REFERENCES connections (id)
);
CREATE INDEX FK_job_connection_id
  ON connection_job (connections_id);
