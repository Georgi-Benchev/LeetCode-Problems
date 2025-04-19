SELECT eui.unique_id, e.name
FROM employees e
LEFT JOIN EmployeeUNI eui ON eui.id = e.id;