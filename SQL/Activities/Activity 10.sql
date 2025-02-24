select * from orders where salesman_id in(select salesman_id from orders where customer_id=3007);
SELECT * FROM orders WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');
SELECT grade, COUNT(*) FROM customers where grade > (SELECT AVG(grade) FROM customers WHERE city='New York') GROUP BY grade;
SELECT * FROM orders
WHERE salesman_id IN(SELECT salesman_id FROM salesman
WHERE comission=(select MAX(comission) from salesman));