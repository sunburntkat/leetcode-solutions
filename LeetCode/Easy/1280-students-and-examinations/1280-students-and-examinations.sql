/* Write your T-SQL query statement below */
WITH exam_attendance AS (
    SELECT student_id, subject_name, COUNT(*) as attended_exams
    FROM Examinations
    GROUP BY student_id, subject_name
)
SELECT s.student_id, s.student_name, sub.subject_name, ISNULL(e.attended_exams,0) as attended_exams 
FROM Students s
CROSS JOIN Subjects sub
LEFT JOIN exam_attendance e
ON s.student_id=e.student_id AND e.subject_name=sub.subject_name
ORDER BY student_id, subject_name