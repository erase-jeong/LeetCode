(
SELECT name AS results
FROM MovieRating JOIN Users USING(user_id)
GROUP BY name
ORDER BY COUNT(*) DESC, name
LIMIT 1
)
UNION ALL
(
SELECT title
FROM MovieRating  mr JOIN Movies  m 
    ON mr.movie_id=m.movie_id
WHERE DATE_FORMAT(created_at, "%Y-%m")='2020-02'
GROUP BY m.movie_id
ORDER BY AVG(rating) DESC, title
LIMIT 1
)


-- WHERE DATE_FORMAT("YYYY-MM",2020-02")=created_at