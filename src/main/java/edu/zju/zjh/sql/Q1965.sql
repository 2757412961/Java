# MySQL不支持OUTER JOIN, 但是我们可以对左连接和右连接的结果做UNION操作来实现。

SELECT e.employee_id
FROM Employees e LEFT JOIN Salaries s ON e.employee_id = s.employee_id
WHERE salary IS NULL
UNION
SELECT s.employee_id
FROM Employees e RIGHT JOIN Salaries s ON e.employee_id = s.employee_id
WHERE name IS NULL
ORDER BY employee_id