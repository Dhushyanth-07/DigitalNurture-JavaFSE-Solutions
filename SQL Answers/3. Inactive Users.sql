SELECT u.user_id, u.full_name, u.email, MAX(r.registration_date) as last_registration
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
GROUP BY u.user_id
HAVING last_registration IS NULL 
OR last_registration < DATE_SUB(CURDATE(), INTERVAL 90 DAY);