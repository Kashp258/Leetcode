/* Write your T-SQL query statement below */

SELECT MAX(num) num 
FROM 
(SELECT num FROM 
MyNumbers
GROUP BY 
num
HAVING COUNT(num)=1) m
