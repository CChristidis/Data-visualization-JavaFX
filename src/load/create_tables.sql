CREATE DATABASE mye030;
USE mye030;

CREATE TABLE country(
  id INT,
  name VARCHAR(255),
  code VARCHAR(255),
  PRIMARY KEY(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE indicator(
  id INT,
  name VARCHAR(255),
  code VARCHAR(255),
  PRIMARY KEY(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE indicates(
  id_country INT,
  id_ind INT, 
  year INT,
  value FLOAT,
  PRIMARY KEY(id_country, id_ind, year),
  CONSTRAINT `country_id` FOREIGN KEY (id_country) REFERENCES country (id),
  CONSTRAINT `ind_id` FOREIGN KEY (id_ind) REFERENCES indicator (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
