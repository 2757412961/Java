Select event_day As day, emp_id, Sum(out_time - in_time) As total_time
From Employees
Group By day, emp_id