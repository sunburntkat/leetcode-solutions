/* Write your T-SQL query statement below */
SELECT FORMAT(trans_date, 'yyyy-MM') as month,
    country,
    COUNT(*) as trans_count, 
    COUNT(CASE WHEN state = 'approved' THEN 1 END) AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) as approved_total_amount
FROM Transactions
GROUP BY FORMAT(trans_date, 'yyyy-MM'), country;
