------------------------------------------------------------------------------[DDL FILE]------------------------------------------------------------------------------

DROP TABLE employee;
DROP TABLE employee_history;

CREATE TABLE employee ( log_id smallint NOT NULL, emp_name character(100) NOT NULL, emp_email character(20) NOT NULL, emp_phone character(14));
CREATE TABLE employee_history ( log_id smallint NOT NULL);


------------------------------------------------------------------------------[DML FILE]------------------------------------------------------------------------------

INSERT INTO EMPLOYEE (log_id, emp_name, emp_email, emp_phone) VALUES (1,'ABC', 'abc@gmail.com', '1234567890');
INSERT INTO EMPLOYEE (log_id, emp_name, emp_email, emp_phone) VALUES (2,'PQR', 'pqr@gmail.com', '1234567890');
INSERT INTO EMPLOYEE (log_id, emp_name, emp_email, emp_phone) VALUES (3,'XYZ', 'xyz@gmail.com', '1234567890');
--
INSERT INTO EMPLOYEE (log_id,emp_name, emp_email, emp_phone) VALUES (6,'AXX', 'axx@gmail.com', '1234567890');
INSERT INTO EMPLOYEE (log_id,emp_name, emp_email, emp_phone) VALUES (7,'AYY', 'ayy@gmail.com', '1234567890');
INSERT INTO EMPLOYEE (log_id,emp_name, emp_email, emp_phone) VALUES (8,'AZZ', 'azz@gmail.com', '1234567890');


------------------------------------------------------------------------------[COMMANDS]------------------------------------------------------------------------------

select * from employee;
select * from employee_history;

--

CREATE OR REPLACE FUNCTION trigger_testing()
RETURNS trigger AS $test_trigger$
   BEGIN
      INSERT INTO employee_history (log_id) VALUES (new.log_id);
      RETURN NEW;
   END; $test_trigger$
LANGUAGE plpgsql;

--

DROP TRIGGER trigger_test ON employee;

CREATE TRIGGER trigger_test
  AFTER INSERT ON employee
     FOR EACH ROW
EXECUTE PROCEDURE trigger_testing();
