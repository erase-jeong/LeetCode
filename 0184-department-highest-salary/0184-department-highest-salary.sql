

# Write your MySQL query statement below
/*select a.name as Department,b.name as Employee,b.salary as Salary from
Department a join Employee b on a.id=b.departmentId
where b.salary=( select max(salary) from Employee group by departmentId having departmentId=b.departmentId )*/

/*
SELECT Department.name AS Department ,Employee.name AS Employee, Employee.salary
FROM Department  JOIN Employee  ON Employee.departmentId=Department.id 
WHERE(departmentId, salary) IN
    (SELECT departmentId,MAX(salary) 
     FROM Employee 
     GROUP BY departmentId) ;
*/

SELECT d.name as Department, e.name as Employee, salary as Salary
FROM Department as d join Employee as e
    ON d.id=e.departmentId
where (departmentId,salary) IN
    (SELECT departmentId, MAX(salary)
    FROM Employee
    GROUP BY departmentId)