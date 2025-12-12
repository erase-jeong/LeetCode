SELECT 
    DATE_FORMAT(trans_date, '%Y-%m') as month, 
    country, 
    count(*) as trans_count, 
    sum(CASE WHEN state='approved' THEN 1 ELSE 0 END) as approved_count,
    -- sum(state='approved') AS approved_count2,
    sum(amount) as trans_total_amount,
    sum(CASE WHEN state='approved' THEN amount ELSE 0 END ) as approved_total_amount
FROM Transactions
GROUP BY DATE_FORMAT(trans_date,'%Y-%m'), country

/*
-- 이게 왜 가능한건지 체크하기
SELECT *  -- DATE_FORMAT(trans_date,'%Y-%m') as qq
FROM Transactions
GROUP BY DATE_FORMAT(trans_date,'%Y-%m')
*/


-- GROUP BY country


-- GROUP BY DATE_FORMAT(trans_date, '%Y-%m')

/*
각 월별 국가별 - 거래 건수, 총액, 승인된 거래 건수, 총액
*/