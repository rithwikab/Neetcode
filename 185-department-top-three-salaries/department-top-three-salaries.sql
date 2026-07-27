# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as Salary from 
(
    select emp.*,
    dense_rank() over(partition by emp.departmentId order by emp.salary desc) as ranked_salary
    from Employee emp
) as e
inner join 
Department d
on e.departmentID = d.id where ranked_salary <= 3;