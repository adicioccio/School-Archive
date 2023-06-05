
-- Query for SELF JOIN

SELECT * FROM Employee_T;

SELECT 
    e1.EmployeeID AS "Employee ID",
    e1.EmpName    AS "Employee Name",
    e2.EmpName    AS "Manager Name"
FROM
    Employee_T e1,
    Employee_T e2
WHERE
    e2.EmployeeID = e1.ManagerID;
    
