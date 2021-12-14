insert into user (username, active, created, email, password, roles)
values
('admin', true, now(), 'admin@pansa.pl', 'admin', 'ROLE_ADMIN'),
('employee', true, now(), 'employee@pansa.pl', 'employee', 'ROLE_EMPLOYEE'),
('applicant', true, now(), 'applicant@mail.com', 'applicant', 'ROLE_APPLICANT');