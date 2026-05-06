SELECT d.name as Department, e.name as Employee, e.salary as Salary 
FROM Employee e JOIN Department d 
    ON e.departmentID=d.id
WHERE (departmentId, salary) IN (
    SELECT departmentId,MAX(salary) as salary
    FROM Employee
    GROUP BY departmentId
)




/*
각 부서에서 제일 월급이 높은 애가 누구야?
-> join해서 테이블의 상태를 먼저 파악한다.
-> 각 그룹별로 group by 해서 상황 파악한 다음에, 
그 중에서 제일 큰 애 max값을 출력하고,
이걸 서브쿼리? 이용해서 또 여기에 해당되는 애들을 출력하는 구조??
*/