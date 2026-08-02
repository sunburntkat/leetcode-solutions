/* Write your T-SQL query statement below */
SELECT u.unique_id, e.name
FROM Employees e
LEFT JOIN EmployeeUNI u
ON e.id=u.id;