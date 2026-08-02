/* Write your T-SQL query statement below */
SELECT b.name
FROM Employee a
JOIN Employee b
ON a.managerId=b.id  
GROUP BY a.managerId, b.name
HAVING COUNT(*)>=5