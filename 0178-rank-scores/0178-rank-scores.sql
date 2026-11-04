# Write your MySQL query statement below
Select score as score,DENSE_RANK() OVER (ORDER BY score DESC) as `rank`
from Scores 
