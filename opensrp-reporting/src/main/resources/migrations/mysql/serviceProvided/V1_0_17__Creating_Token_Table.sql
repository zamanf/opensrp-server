CREATE TABLE report.token (ID INT(11) NOT NULL AUTO_INCREMENT , name VARCHAR(255) NOT NULL, value VARCHAR(255) NOT NULL,
  CONSTRAINT pk_token PRIMARY KEY (ID),
  CONSTRAINT U_TOKEN_NAME UNIQUE (name));