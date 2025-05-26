SELECT 
    e.title,
    SUM(CASE WHEN res.resource_type = 'pdf' THEN 1 ELSE 0 END) as pdf_count,
    SUM(CASE WHEN res.resource_type = 'image' THEN 1 ELSE 0 END) as image_count,
    SUM(CASE WHEN res.resource_type = 'link' THEN 1 ELSE 0 END) as link_count
FROM Events e
LEFT JOIN Resources res ON e.event_id = res.event_id
GROUP BY e.event_id;