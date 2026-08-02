/* Write your T-SQL query statement below */
SELECT machine_id, 
    ROUND(SUM(
        CASE 
        WHEN activity_type='start'
        THEN
            -timestamp
        ELSE
            timestamp
        END
        )/(COUNT(process_id)/2) ,3
    ) as processing_time
FROM Activity
GROUP BY machine_id;