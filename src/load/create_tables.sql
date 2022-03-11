CREATE DATABASE mye030;
USE mye030;

CREATE TABLE country(
  id INT,
  name VARCHAR(255),
  code VARCHAR(255),
  PRIMARY KEY(id)
);

CREATE TABLE indicator(
  id INT,
  name VARCHAR(255),
  code VARCHAR(255),
  PRIMARY KEY(id)
);

CREATE TABLE indicates(
  id_country INT,
  id_ind INT, 
  year INT,
  value FLOAT,
  PRIMARY KEY(id_country, id_ind, year)
);
 
  

  
