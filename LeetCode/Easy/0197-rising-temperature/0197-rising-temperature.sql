/* Write your T-SQL query statement below */
SELECT Id
FROM (
    SELECT id, temperature, recordDate,
    LAG(temperature) OVER(ORDER BY recordDate) as lagTemp,
    LAG(recordDate) OVER(ORDER BY recordDate) as lagDate
    FROM Weather 
) AS t 
WHERE temperature>lagTemp AND DATEDIFF(day, lagDate, recordDate)=1; 
--DATEDIFF(partOfDate, startDate, endDate) -> endDate-startDate
