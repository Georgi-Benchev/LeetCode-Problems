SELECT v.customer_id as customer_id, COUNT(v.visit_id) as count_no_trans
FROM visits v
LEFT JOIN Transactions t ON t.visit_id = v.visit_id
WHERE t.transaction_id is null
GROUP BY v.customer_id;