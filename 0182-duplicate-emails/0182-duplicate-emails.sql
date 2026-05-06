SELECT Email
FROM Person
GROUP BY email
HAVING count(email)>=2

/*
각 이메일로 group by -> cnt 세서 2개 이상이다 -> 출력하자
*/