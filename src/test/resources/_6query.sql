select ceil(AVG(salary) - AVG(cast(REPLACE(cast(salary as char(4)),'0','') as int))) from employees;