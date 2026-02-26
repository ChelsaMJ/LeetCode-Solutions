# Write your MySQL query statement below
SELECT 
    s.score,
    COUNT(DISTINCT s2.score) AS "rank"
FROM 
    Scores s
JOIN 
    Scores s2 ON s.score <= s2.score
GROUP BY 
    s.id, s.score
ORDER BY 
    s.score DESC;


