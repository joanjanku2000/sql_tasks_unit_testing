select
   concat(c.company_code ,' ', max(c.founder) ,' ', count(distinct lm.lead_manager_code) ,' ',
    count( distinct sm.senior_manager_code) ,' ', count(distinct m.manager_code),' ', count(distinct
                                                                                    e.employee_code))
from company c
         inner join Lead_Manager lm on lm.company_code = c.company_code
         inner join Senior_Manager sm on sm.company_code = c.company_code
         inner join Manager m on m.company_code = c.company_code
         inner join c_employee e on e.company_code = c.company_code
group by c.company_code
order by c.company_code;
