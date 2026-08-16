# Write your MySQL query statement below
with Manager as (
    select id ,salary from Employee 
)

Select name as `Employee` from Employee e ,Manager m where e.managerId=m.id and e.salary>m.salary; 