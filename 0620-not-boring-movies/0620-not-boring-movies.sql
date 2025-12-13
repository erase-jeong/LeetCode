SELECT * 
FROM Cinema
WHERE (id) IN
    (SELECT  
        case 
            when id%2=1 then id
            else null
            end as ID
    FROM Cinema) and description !='boring'
ORDER BY rating DESC;

