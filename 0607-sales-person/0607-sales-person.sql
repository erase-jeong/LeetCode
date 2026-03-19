SELECT name
FROM SalesPerson
WHERE SalesPerson.sales_id NOT IN (SELECT sales_id
    FROM Company INNER JOIN Orders
        ON Company.com_id=Orders.com_id
    WHERE Company.name="RED"
)

