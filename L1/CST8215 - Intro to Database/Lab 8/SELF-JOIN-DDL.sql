
DROP TABLE IF EXISTS Employee_T;

CREATE TABLE Employee_T(
    EmployeeID 	CHAR(  2 ), 
    EmpName 	CHAR( 20 ),
    ManagerID 	CHAR(  2 ),
    CONSTRAINT  EmployeeID_PK PRIMARY KEY( EmployeeID )
);

-- adding constraint after the table has been created.
ALTER TABLE Employee_T 
   ADD CONSTRAINT ManagerID_FK 
   FOREIGN KEY( ManagerID ) 
   REFERENCES Employee_T( EmployeeID );
