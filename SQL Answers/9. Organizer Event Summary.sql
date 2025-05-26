SELECT 
    u.full_name as organizer,
    COUNT(e.event_id) as total_events,
    SUM(CASE WHEN e.status = 'upcoming' THEN 1 ELSE 0 END) as upcoming_count,
    SUM(CASE WHEN e.status = 'completed' THEN 1 ELSE 0 END) as completed_count,
    SUM(CASE WHEN e.status = 'cancelled' THEN 1 ELSE 0 END) as cancelled_count
FROM Events e
JOIN Users u ON e.organizer_id = u.user_id
GROUP BY e.organizer_id;