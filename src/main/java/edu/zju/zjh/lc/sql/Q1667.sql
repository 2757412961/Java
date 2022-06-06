SELECT user_id, CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2, length(name)))) As 'name'
FROM Users
ORDER BY user_id