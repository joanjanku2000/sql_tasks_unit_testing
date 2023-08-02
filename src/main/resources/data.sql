insert into occupations
values
    ('Samantha', 'Doctor'),
    ('Julia', 'Actor'),
    ('Maria', 'Actor'),
    ('Meera', 'Singer'),
    ('Ashely', 'Professor'),
    ('Ketty', 'Professor'),
    ('Christeen', 'Professor'),
    ('Jane', 'Professor'),
    ('Jenny', 'Doctor'),
    ('Priya', 'Singer');

insert into employee
values
    (1, 'Rose', 15 , 1968),
    (2, 'Angela', 1 , 3443),
    (3, 'Frank', 17 , 1608),
    (4, 'Patrick', 7 , 1345),
    (5, 'Lisa', 11 , 2330),
    (6, 'Kimberly', 16 , 4372),
    (7, 'Bonnie', 8 , 1771),
    (8, 'Michael', 6 , 2017),
    (9, 'Todd', 5 , 3396),
    (10, 'Joe', 9 , 3573);

insert into employees
values
    (1,'Kristeen',1420),
    (2,'Ashley',2006),
    (3,'Julia',2210),
    (4,'Maria',3000);

insert into company
values
        ('C1', 'Monika'),
        ('C2', 'Samantha');

insert into lead_manager
values
    ('LM1','C1'),
    ('LM2','C2');

insert into senior_manager
values
    ('SM1','LM1', 'C1'),
    ('SM2','LM1', 'C1'),
    ('SM3','LM2', 'C2');

insert into manager
values ('M1','SM1','LM1','C1'),
       ('M2','SM3','LM2','C2'),
        ('M3','SM3','LM2','C2');

insert into c_employee
values ('E1','M1', 'SM1','LM1','C1'),
       ('E2','M1', 'SM1', 'LM1', 'C1'),
       ('E3','M2', 'SM3', 'LM2', 'C2'),
       ('E4','M3', 'SM3', 'LM2','C2');
