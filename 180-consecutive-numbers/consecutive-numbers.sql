# Write your MySQL query statement below
with shiftedlog as(
    select 
    num,
    lead(num,1) over () as nn,
    lead(num,2) over () as nnn
    from 
    Logs
)
select distinct num as ConsecutiveNums from shiftedlog
where
num=nn && num =nnn;