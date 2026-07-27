# Write your MySQL query statement below
SELECT score, score_rank AS `rank`
FROM (
    SELECT
        score,
        DENSE_RANK() OVER (ORDER BY score DESC) AS score_rank
    FROM Scores
) as ranked_score;