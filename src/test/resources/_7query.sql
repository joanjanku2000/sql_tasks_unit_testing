select concat(max(months*salary), ' ', count(*))
from Employee
where months*salary =(select max(months*salary) as earnings from Employee)