SELECT u.city, COUNT(DISTINCT r.user_id) as user_count
FROM Registrations r
JOIN Users u ON r.user_id = u.user_id
GROUP BY u.city
ORDER BY user_count DESC
LIMIT 5;