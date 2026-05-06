SELECT w2.id as Id
FROM Weather w1, Weather w2
WHERE DATEDIFF(w2.recordDate,w1.recordDate)=1 and w1.temperature<w2.temperature;