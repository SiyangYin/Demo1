-- emp_id | emp_name | job_name  | manager_id | hire_date  | salary  | commission | dep_id
-- --------+----------+-----------+------------+------------+---------+------------+--------
--   69062 | FRANK    | ANALYST   |      65646 | 1991-12-03 | 3100.00 |       0.00 |   2001
--   63679 | SANDRINE | CLERK     |      69062 | 1990-12-18 |  900.00 |       0.00 |   2001
--   64989 | ADELYN   | SALESMAN  |      66928 | 1991-02-20 | 1700.00 |     400.00 |   3001
--   65271 | WADE     | CLERK     |      66928 | 1991-02-22 | 1350.00 |     600.00 |   3001
--   66564 | MADDEN   | SALESMAN  |      66928 | 1991-09-28 | 1350.00 |    1500.00 |   3001

-- Write a query in SQL to find the average salary and average total remuneration(salary and commission) for each type of job.
--
-- table: employees

select AVG(employees.salary), AVG(employees.salary + employees.commission)
from employees
group by employees.job_name