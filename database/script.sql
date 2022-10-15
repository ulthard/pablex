CREATE DATABASE PABLEX;

CREATE TABLE CONSUMERS (
    CONSUMERS_ID INT PRIMARY KEY AUTO_INCREMENT,
    CONSUMERS_FIRSTNAME VARCHAR(50) NOT NULL,
    CONSUMERS_LASTNAME VARCHAR(50) NOT NULL,
    CONSUMERS_CHECK BOOLEAN NOT NULL,
    CONSUMERS_KEY VARCHAR(50) UNIQUE NOT NULL
); 

INSERT INTO CONSUMERS (CONSUMERS_FIRSTNAME, CONSUMERS_LASTNAME, CONSUMERS_CHECK, CONSUMERS_KEY)
  VALUES ('TOTO','TOTO',FALSE,'TOTO');
INSERT INTO CONSUMERS (CONSUMERS_FIRSTNAME, CONSUMERS_LASTNAME, CONSUMERS_CHECK, CONSUMERS_KEY)
  VALUES ('TATA','TATA',FALSE,'TATA');