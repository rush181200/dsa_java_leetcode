# Write your MySQL query statement below
# SELECT p.product_name,s.year,s.price
# FROM SALES AS s
# LEFT JOIN Product AS p ON s.product_id = p.product_id

select p.product_name, year, price from Sales as s left join Product as p on s.product_id = p.product_id