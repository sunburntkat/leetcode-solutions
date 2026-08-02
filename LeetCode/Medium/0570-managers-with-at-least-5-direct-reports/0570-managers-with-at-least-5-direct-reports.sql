/* Write your T-SQL query statement below */
SELECT name
FROM Employee a
WHERE (SELECT count(*) FROM Employee b WHERE b.managerId=a.id)>=5;