SELECT 
    score, 
    DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'
FROM Scores

/*
순위매기는 함수

*/