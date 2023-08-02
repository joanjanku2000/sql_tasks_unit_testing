create table occupations(
    name varchar(255),
    occupation varchar(255)
);

create table employee(
    employee_id int,
    name varchar(255),
    months int,
    salary int
);

create table employees(
    id int,
    name varchar(255),
    salary int
);

create table company(
    company_code varchar(255),
    founder varchar(255)
);

create table lead_manager(
    lead_manager_code varchar(255),
    company_code varchar(255)
);

create table senior_manager(
    senior_manager_code varchar(255),
    lead_manager_code varchar(255),
    company_code varchar(255)
);

create table manager(
    manager_code varchar(255),
    senior_manager_code varchar(255),
    lead_manager_code varchar(255),
    company_code varchar(255)
);

create table c_employee (
    employee_code varchar(255),
    manager_code varchar(255),
    senior_manager_code varchar(255),
    lead_manager_code varchar(255),
    company_code varchar(255)
);