
select d.dept_name, count(*)
from Department d
join Employee e
on d.dept_id = e.dept_id
group by d.dept_name