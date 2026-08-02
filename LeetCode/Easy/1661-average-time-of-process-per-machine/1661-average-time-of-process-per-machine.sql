/* Write your T-SQL query statement below */
SELECT machine_id, ROUND(AVG(endTime-startTime),3) AS processing_time
FROM (
    SELECT machine_id, activity_type,
        timestamp as startTime, 
        LEAD(timestamp) OVER(PARTITION BY machine_id, process_id ORDER BY timestamp) as endTime
    FROM Activity
    ) as t1
    WHERE activity_type='start'
GROUP BY machine_id;