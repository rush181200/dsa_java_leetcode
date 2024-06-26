# Write your MySQL query statement below
# SELECT EmployeeUNI.unique_id, Employees.name
# FROM Employees 
# LEFT JOIN EmployeeUNI ON Employees.id = EmployeeUNI.id

select eu.unique_id, e.name
from Employees e
left join EmployeeUNI eu
on e.id = eu.id