SELECT s.salesman_name, s.salesman_id, c.customer_name, c.customer_id
FROM salesman s
JOIN customers c ON s.salesman_id = c.salesman_id
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY s.salesman_name, s.salesman_id, c.customer_name, c.customer_id
HAVING COUNT(o.order_no) > 1
ORDER BY c.customer_name, s.salesman_name;


SELECT a.salesman_id, a.salesman_name, b.order_no, 'highest on', b.order_date, b.purchase_amount FROM salesman a, orders b WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount= (SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
SELECT f.salesman_id, f.salesman_name, d.order_no, 'lowest on', d.order_date, d.purchase_amount FROM salesman f, orders d WHERE f.salesman_id=d.salesman_id
AND d.purchase_amount=(SELECT MIN(purchase_amount) FROM orders e WHERE e.order_date = d.order_date)
and (SELECT COUNT(*) FROM orders e WHERE e.order_date = d.order_date) > 1;