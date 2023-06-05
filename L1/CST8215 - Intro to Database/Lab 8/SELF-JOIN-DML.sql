
DELETE FROM Employee_T;

INSERT INTO Employee_T( EmployeeID, EmpName ) VALUES( 'g1', 'Guoh' );
INSERT INTO Employee_T( EmployeeID, EmpName ) VALUES( 't1', 'Teef' );
INSERT INTO Employee_T( EmployeeID, EmpName ) VALUES( 'h1', 'Heot' );
INSERT INTO Employee_T( EmployeeID, EmpName ) VALUES( 'm1', 'Meit' );
INSERT INTO Employee_T( EmployeeID, EmpName ) VALUES( 'h2', 'Hoij' );
INSERT INTO Employee_T( EmployeeID, EmpName ) VALUES( 'm2', 'Mooq' );

-- managerID for an Employee_T can be entered only if the 
-- Employee_T being managed has been entered

UPDATE Employee_T SET ManagerID = 't1' WHERE EmployeeID = 'g1';
UPDATE Employee_T SET ManagerID = 'm2' WHERE EmployeeID = 't1';
UPDATE Employee_T SET ManagerID = 't1' WHERE EmployeeID = 'h1';
UPDATE Employee_T SET ManagerID = 'g1' WHERE EmployeeID = 'm1';
UPDATE Employee_T SET ManagerID = 'g1' WHERE EmployeeID = 'h2';

SELECT * FROM Employee_T;

