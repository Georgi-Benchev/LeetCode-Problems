Select a.machine_id, ROUND(AVG(ae.timestamp - a.timestamp), 3) as processing_time
FROM activity a
JOIN activity ae on a.machine_id = ae.machine_id and a.activity_type = 'start' and ae.activity_type = 'end'
GROUP BY a.machine_id;