SELECT 
    DATE(registration_date) as registration_day,
    COUNT(user_id) as new_users
FROM Users
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
GROUP BY DATE(registration_date)
ORDER BY registration_day;