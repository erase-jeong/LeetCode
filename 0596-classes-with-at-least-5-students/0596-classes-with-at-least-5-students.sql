SELECT class
FROM (
    SELECT class, COUNT(class) AS cnt
    FROM Courses
    GROUP BY class
) sub
WHERE cnt >= 5