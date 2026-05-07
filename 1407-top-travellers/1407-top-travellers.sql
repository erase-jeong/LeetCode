/*
1. Rides group by
2. 1이랑 Users JOIN
3. 결과 출력
*/

SELECT name,IFNULL(sumD,0) as travelled_distance
FROM Users LEFT JOIN 
    (SELECT user_id, SUM(distance) as sumD
    FROM Rides
    GROUP BY user_id) as tmp
    ON Users.id=tmp.user_id
ORDER BY travelled_distance DESC, name ASC