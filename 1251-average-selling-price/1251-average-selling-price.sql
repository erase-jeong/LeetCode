/*
LEFT JOIN, IFNULL 
*/

SELECT product_id, ROUND(IFNULL(SUM(sum_v)/SUM(units),0),2) AS average_price
FROM (
    SELECT p.product_id, units, price*units as sum_v
    FROM Prices p LEFT JOIN UnitsSold us 
        ON p.product_id=us.product_id AND (p.start_date<=us.purchase_date) AND (us.purchase_date<=p.end_date)
    ) tmp
GROUP BY product_id
