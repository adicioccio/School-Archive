/*
Assigment 1
Adam Di Cioccio and Osman Dirane
CST8215 SECTION 321
Souhail Abdala
Due October 18, 2020
*/

--------------------------------------------------------------------------{DDL FILE}------------------------------------------------------------------------------------

--drop views if they exist
DROP VIEW IF EXISTS V_CanadianCities;
DROP VIEW IF EXISTS V_CitiesOver500k;
DROP VIEW IF EXISTS V_CntryNoCustomers;
DROP VIEW IF EXISTS V_CntryNoProducts;

-- drop tables if they exist
DROP TABLE IF EXISTS Invoice_Line_T;
DROP TABLE IF EXISTS Product_T;
DROP TABLE IF EXISTS Invoice_T;
DROP TABLE IF EXISTS Customer_T;
DROP TABLE IF EXISTS City;
DROP TABLE IF EXISTS Country;

-- country table
CREATE TABLE Country (
  Cntry_Code TEXT NOT NULL default '' PRIMARY KEY,
  Cntry_Name TEXT NOT NULL default '',
  Cntry_Population INTEGER NOT NULL default '0'
  );

-- city table
CREATE TABLE City (
City_ID SERIAL PRIMARY KEY,
City_Name TEXT NOT NULL DEFAULT '',
Cntry_Code TEXT NOT NULL DEFAULT '' REFERENCES Country( Cntry_Code ),
City_Population INTEGER NOT NULL DEFAULT '0'
);

-- customer_t table
CREATE TABLE Customer_T (
  Cust_Id         CHAR( 4 ),
  Cust_Fname      VARCHAR( 30 ) NULL,
  Cust_Lname      VARCHAR( 30 ) NOT NULL,
  Cust_Phone      VARCHAR( 15 ) NOT NULL,
  Cust_Address    VARCHAR( 20 ) NOT NULL,
  Cust_City       VARCHAR( 15 ) NOT NULL,
  Cust_Prov       CHAR( 2 ) NULL,
  Cust_PostCode   CHAR( 6 ) NOT NULL,
  Cust_Balance    DECIMAL( 9, 2 ),
  Cust_Cntry	  TEXT	NOT NULL default '',
  CONSTRAINT PK_Customer PRIMARY KEY( Cust_Id ),
  CONSTRAINT FK_Cntry_Code FOREIGN KEY ( Cust_Cntry ) REFERENCES Country( Cntry_Code )
);

-- invoice_t table
CREATE TABLE Invoice_T (
  Invoice_Number     CHAR( 6 ),
  Cust_Id            CHAR( 4 ) NOT NULL,
  Invoice_Date       DATE DEFAULT NOW(),
  CONSTRAINT PK_Invoice PRIMARY KEY( Invoice_Number ),
  CONSTRAINT FK_Cust_ID FOREIGN KEY( Cust_Id ) REFERENCES Customer_T( Cust_ID )
);

-- product_t table
CREATE TABLE Product_T (
  Prod_Code        CHAR( 5 ),
  Prod_Description VARCHAR( 60 ) NOT NULL,
  Prod_Indate      DATE NOT NULL DEFAULT NOW(),
  Prod_QOH         INTEGER NOT NULL,
  Prod_Min         INTEGER,
  Prod_Price       DECIMAL( 5, 2 ) NOT NULL,
  Prod_Discount    INTEGER,
  Cntry_Origin	   TEXT NOT NULL default '',
  CONSTRAINT PK_Product PRIMARY KEY( Prod_Code ),
  CONSTRAINT FK_Cntry_Origin FOREIGN KEY ( Cntry_Origin ) REFERENCES Country( Cntry_Code )
);

-- invoice_line_t table
CREATE TABLE Invoice_Line_T (
  Invoice_Number       CHAR( 6 ),
  Invoice_Line         INTEGER,
  Prod_Code CHAR( 5 )  NOT NULL,
  Line_Unit            INTEGER NOT NULL,
  Line_Price           DECIMAL( 9, 2 ) NOT NULL,
  CONSTRAINT PK_Invoice_Line  PRIMARY KEY( Invoice_Number, Invoice_Line ),
  CONSTRAINT FK1_Invoice_Line FOREIGN KEY( Invoice_Number ) REFERENCES Invoice_T( Invoice_Number ),
  CONSTRAINT FK2_Invoice_Line FOREIGN KEY( Prod_Code ) REFERENCES Product_T( Prod_Code )
);

-- create view statements (from workbook)
CREATE VIEW V_CanadianCities AS SELECT * FROM City WHERE Cntry_Code = 'CAN';
CREATE VIEW V_CitiesOver500k AS SELECT * FROM City WHERE City_Population > 500000; 

-- delete statements
DELETE FROM Customer_T WHERE Cust_Cntry = 'CHL'; 
DELETE FROM Product_T WHERE Cntry_Origin = 'RUS';

-- create view and join statements
CREATE VIEW V_CntryNoCustomers AS SELECT * FROM Country LEFT JOIN Customer_T ON Country.Cntry_Code = Customer_T.Cust_Cntry WHERE Cust_Cntry IS NULL;
CREATE VIEW V_CntryNoProducts AS SELECT * FROM Product_T RIGHT JOIN Country ON Country.Cntry_Code = Product_T.Cntry_Origin WHERE Cntry_Origin IS NULL; 

--------------------------------------------------------------------------{DML FILE}------------------------------------------------------------------------------------
-- country inserts
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'RUS', 'Russian Federation', 144192450 ); 
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'MEX', 'Mexico', 119530753 ); 
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'CAN', 'Canada', 36155487 ); 
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'DZA', 'Algeria', 40400000 ); 
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'CHN', 'China', 1376049000 ); 
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'CHL', 'Chile', 18006407 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'ITA','Italy', 57680000 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'AUT','Austria', 8091800 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'JAM','Jamaica', 2583000 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'JPN','Japan', 126714000 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'YEM','Yemen', 18112000 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'JOR','Jordan', 5083000 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'YUG','Yugoslavia', 10640000 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ( 'KHM','Cambodia', 11168000 );
INSERT INTO Country( Cntry_Code, Cntry_Name, Cntry_Population ) VALUES ('USA','United States', 278357000 );

-- city inserts
INSERT INTO City VALUES (1810,'Montréal','CAN',1016376);
INSERT INTO City VALUES (1811,'Calgary','CAN',768082);
INSERT INTO City VALUES (1812,'Toronto','CAN',688275);
INSERT INTO City VALUES (1813,'North York','CAN',622632);
INSERT INTO City VALUES (1814,'Winnipeg','CAN',618477);
INSERT INTO City VALUES (1815,'Edmonton','CAN',616306);
INSERT INTO City VALUES (1816,'Mississauga','CAN',608072);
INSERT INTO City VALUES (1817,'Scarborough','CAN',594501);
INSERT INTO City VALUES (1818,'Vancouver','CAN',514008);
INSERT INTO City VALUES (1819,'Etobicoke','CAN',348845);
INSERT INTO City VALUES (1820,'London','CAN',339917);
INSERT INTO City VALUES (1821,'Hamilton','CAN',335614);
INSERT INTO City VALUES (1822,'Ottawa','CAN',335277);
INSERT INTO City VALUES (1823,'Laval','CAN',330393);
INSERT INTO City VALUES (1824,'Surrey','CAN',304477);
INSERT INTO City VALUES (1825,'Brampton','CAN',296711);
INSERT INTO City VALUES (1826,'Windsor','CAN',207588);
INSERT INTO City VALUES (1827,'Saskatoon','CAN',193647);
INSERT INTO City VALUES (1828,'Kitchener','CAN',189959);
INSERT INTO City VALUES (1829,'Markham','CAN',189098);
INSERT INTO City VALUES (1830,'Regina','CAN',180400);
INSERT INTO City VALUES (1831,'Burnaby','CAN',179209);
INSERT INTO City VALUES (1832,'Québec','CAN',167264);
INSERT INTO City VALUES (3812,'Boston','USA',589141);
INSERT INTO City VALUES (3813,'Washington','USA',572059);
INSERT INTO City VALUES (3814,'Nashville-Davidson','USA',569891);
INSERT INTO City VALUES (3815,'El Paso','USA',563662);
INSERT INTO City VALUES (3816,'Seattle','USA',563374);
INSERT INTO City VALUES (3817,'Denver','USA',554636);
INSERT INTO City VALUES (3818,'Charlotte','USA',540828);
INSERT INTO City VALUES (3819,'Fort Worth','USA',534694);
INSERT INTO City VALUES (3820,'Portland','USA',529121);
INSERT INTO City VALUES (3821,'Oklahoma City','USA',506132);
INSERT INTO City VALUES (3822,'Tucson','USA',486699);
INSERT INTO City VALUES (3823,'New Orleans','USA',484674);
INSERT INTO City VALUES (3824,'Las Vegas','USA',478434);
INSERT INTO City VALUES (3825,'Cleveland','USA',478403);
INSERT INTO City VALUES (3826,'Long Beach','USA',461522);
INSERT INTO City VALUES (3827,'Albuquerque','USA',448607);
INSERT INTO City VALUES (3828,'Kansas City','USA',441545);

-- customer inserts
INSERT INTO Customer_T( Cust_Id, Cust_Fname, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry )
  VALUES( 'C001', 'Adam', 'Di Cioccio', '613-262-4723', '1385 Woodroffe Ave', 'Ottawa', 'ON', 'K2G1V8', 343, 'CAN' );
INSERT INTO Customer_T( Cust_Id, Cust_Fname, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry )
  VALUES( 'C002', 'John', 'Smith', '613-727-1943', '123 Street', 'Ottawa', 'ON', 'K2G1V8', 1099, 'CAN' );
INSERT INTO Customer_T( Cust_Id, Cust_Fname, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry )
  VALUES( 'C003', 'Sam', 'Green', '613-541-4723', '1385 Woodroffe Ave', 'Ottawa', 'ON', 'K2G1V8', 0, 'CAN' );
INSERT INTO Customer_T( Cust_Id, Cust_Fname, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry )
  VALUES( 'C004', 'Daniel', 'Rogers', '613-260-4820', '854 Younge Street' , 'Toronto','ON', 'K2G1V8', 23, 'CAN' );
INSERT INTO Customer_T( Cust_Id, Cust_Fname, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry )
  VALUES( 'C005', 'David', 'Donaldson', '613-097-4723', '264 Main Street'   , 'Kitchener', 'ON', 'K2G1V8', 56, 'CAN' );
INSERT INTO Customer_T( Cust_Id, Cust_Fname, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry ) 
  VALUES( 'C006', 'Peter', 'Johnson', '613-127-4223', '357 Rue Catherine' , 'Montreal', 'ON', 'K2G1V8', 4456, 'CAN' );
INSERT INTO Customer_T( Cust_Id, Cust_Fname, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry ) 
  VALUES( 'C007', 'Jacob', 'Shaw', '613-757-543', '37 Rue Catherine' , 'Montreal', 'ON', 'K2G1V8', 446, 'CAN' );
INSERT INTO Customer_T( Cust_Id, Cust_Fname, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry ) 
  VALUES( 'C008', 'Osman', 'Dirane', '613-453-4798', '572 Rue Catherine' , 'Montreal', 'ON', 'K2G1V8', 44563, 'CAN' );
-- mandatory inserts
INSERT INTO Customer_T( Cust_Id, Cust_FName, Cust_Lname, Cust_Phone, Cust_Address, Cust_City, Cust_Prov, Cust_PostCode, Cust_Balance, Cust_Cntry ) 
  VALUES( 'C097', 'Aze', 'Balai', '7-731-707-7243', 'Ulitsa Aleutskaya','Valdivostok', 'VL','VL7SK4', 0, 'RUS' );

-- product inserts
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_Indate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2011', 'Compac Presario', '2011-02-14', 20, 5, 499.99, 0, 'CAN' );
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_Indate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2012', 'HP laptop', '2010-09-25', 40, 5, 529.99, 0, 'CAN' );
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_Indate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2013', 'Samsung LCD', '2010-02-15', 22, 8, 329.99, 0, 'CAN' );
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_Indate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2014', 'Brother Network All-In-One Laser Printer', '2010-10-10', 50, 10, 159.99, 0, 'CAN' );
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_Indate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2015', 'Western Digital External Hard drive', '2010-04-08', 30, 10, 149.99, NULL, 'CAN' );
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_Indate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2016', 'Apple iPad 2 with Wi-Fi + 3G', '2011-02-23', 90, 200, 849.00, 0, 'RUS' );
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_Indate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2017', 'iPAD 2 Smart Cover', '2011-02-14', 70, 10, 45.00, 10, 'CHL' );
-- mandatory inserts
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_InDate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2119', 'Organic Chard', '2018-01-14', 240, 100, 15.00, 5, 'RUS' );
INSERT INTO Product_T( Prod_Code, Prod_Description, Prod_InDate, Prod_QOH, Prod_Min, Prod_Price, Prod_Discount, Cntry_Origin ) 
  VALUES( 'P2020', 'Organic Collard Green', '2018-01-14', 140, 110, 11.00, 5, 'RUS' );

--mandatory inserts (invoice and invoice_line)
INSERT INTO Invoice_T( Invoice_Number, Cust_Id, Invoice_Date ) 
  VALUES( 'I88001', 'C097', '2018-01-15');
INSERT INTO Invoice_Line_T( Invoice_Number, Invoice_Line, Prod_Code, Line_Unit, Line_Price ) 
  VALUES( 'I88001', 1, 'P2119', 3, 15.00 );
INSERT INTO Invoice_Line_T( Invoice_Number, Invoice_Line, Prod_Code, Line_Unit, Line_Price ) 
  VALUES( 'I88001', 2, 'P2020', 3, 11.00 );


