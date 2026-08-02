/* Write your T-SQL query statement below */
SELECT b.name 
FROM (
    SELECT managerId
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(*)>=5
) a
JOIN Employee b
ON a.managerId=b.id  