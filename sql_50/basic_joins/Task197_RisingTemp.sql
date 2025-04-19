SELECT wt.id
FROM weather w
JOIN weather wt on w.recordDate = DATE_SUB(wt.recordDate, INTERVAL 1 DAY)
WHERE w.temperature < wt.temperature;
