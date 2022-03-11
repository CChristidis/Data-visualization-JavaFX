-- Load country csv
LOAD DATA LOCAL INFILE 
  'C:\\Users\\Christos\\Desktop\\MYE30_csv\\country.csv'
INTO TABLE 
  country
CHARACTER SET 
  latin1 
FIELDS OPTIONALLY ENCLOSED BY 
  '"' 
TERMINATED BY 
  ','
LINES TERMINATED BY 
  '\n' 
IGNORE 
  1 
LINES 
  (id, Name, Code);

-- Load indicator csv
LOAD DATA LOCAL INFILE 
  'C:\\Users\\Christos\\Desktop\\MYE30_csv\\indicator.csv'
INTO TABLE 
  indicator
CHARACTER SET 
   latin1 
FIELDS OPTIONALLY ENCLOSED BY 
   '"' 
TERMINATED BY 
   ','
LINES TERMINATED BY 
   '\n' 
IGNORE 
    1 
LINES 
   (id, Name, Code);
  
  
