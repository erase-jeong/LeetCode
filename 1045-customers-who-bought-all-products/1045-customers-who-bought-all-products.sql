SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key)=(SELECT COUNT(product_key) FROM Product);


/*
모든 제품을 산 사람을 찾기!!!
=> 숫자세기 문제이다.
1. Product테이블에 총 몇 종류의 제품이 있는지 확인

2. Customer테이블에서 각 고객이 서로 다른 제품을 몇 종류 샀는지 계산함

3. 고객이 구매한 제품 종류의 수가 전체 제품 종류의 수와 일치하는 사람만 골라내기
*/


/*
SELECT customer_id
FROM 
    (SELECT customer_id,COUNT(DISTINCT product_key) as c_cnt
    FROM Customer
    GROUP BY customer_id
    HAVING c_cnt=(
        SELECT count(product_key) as p_cnt
        FROM Product
        )
    )  as sub  
*/

-- WHERE
-- 개수로만 확인하면  되는건가?? Customer에 없는게 막 있을 수도 있고 그런거 아니야????
