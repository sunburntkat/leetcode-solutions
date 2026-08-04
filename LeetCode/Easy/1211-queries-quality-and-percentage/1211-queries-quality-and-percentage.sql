/* Write your T-SQL query statement below */
SELECT query_name, 
    ROUND(AVG(CONVERT(FLOAT,rating)/position),2) AS quality,
    ROUND(CONVERT(FLOAT, COUNT(CASE WHEN rating<3 THEN 1 END)*100)/COUNT(*),2) AS poor_query_percentage
FROM Queries
GROUP BY query_name