/* Write your T-SQL query statement below */
WITH Ordered_deliveries AS(
    SELECT customer_id,
        order_date, 
        customer_pref_delivery_date , 
        ROW_NUMBER() OVER(PARTITION BY customer_id ORDER BY order_date) as row_number
    FROM Delivery
)
SELECT ROUND(COUNT( CASE WHEN order_date=customer_pref_delivery_date THEN 1 END) * 100.0 / COUNT(*) ,2 ) AS immediate_percentage
FROM Ordered_deliveries
WHERE row_number=1;