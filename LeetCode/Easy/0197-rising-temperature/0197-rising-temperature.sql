/* Write your T-SQL query statement below */
SELECT a.id
FROM Weather a
JOIN Weather b
ON a.recordDate=DATEADD(day, 1, b.recordDate)
WHERE a.temperature>b.temperature;