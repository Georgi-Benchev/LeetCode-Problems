SELECT e.name, b.bonus
FROM employee e
LEFT JOIN bonus b on e.empId = b.empId
WHERE b.bonus is null or b.bonus < 1000;