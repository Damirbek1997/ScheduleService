insert into faculties (faculty)
values ('Faculty of Engineering and Informatics'),
       ('Faculty of Social Sciences'),
       ('Faculty of Economics and Administrative Sciences');

insert into departments (department, faculty_id)
values ('Computer of Science', 1), ('Electronics and Nanoelectronics Engineering', 1), ('Applied Mathematics & Informatics', 1),
       ('Translation and Translation Studies (English Language', 2), ('Philology (English Language and Literature)', 2), ('Psychology', 2),
       ('Pedagogy (Elementary School Teaching)', 2), ('Journalism', 2),
       ('Economics (International Economics and Business)', 3), ('International Relations', 3), ('Management', 3),
       ('Economics (Finance and Credit)', 3), ('International Law', 3);

insert into groups (group_name, department_id)
values ('COM-17b', 1),
       ('ELN-17b', 2),
       ('AMI-17b', 3),
       ('TTSe-17b', 4),
       ('PHe-17b', 5),
       ('PSC-17b', 6),
       ('PST-17b', 7),
       ('JRN-17b', 8),
       ('ECN-17b', 9),
       ('INR-17b', 10),
       ('MAN-17b', 11),
       ('ECNf-17b', 12),
       ('INL-17b', 13);

insert into roles (role)
values ('ROLE_ADMIN'),
       ('ROLE_TEACHER'),
       ('ROLE_STUDENT');

insert into teachers (firstname, lastname, is_deleted)
values ('Ruslan', 'Isaev', false),
       ('Burul', 'Shambetova', false);

insert into users (email, password, role_id, teacher_id, student_id)
values ('admin', 'admin', 1, null, null),
       ('teacher', 'ruslan', 2, 1, null),
       ('teacher2', 'burul', 2, 2, null);

update teachers
set user_id = 2
where id = 1;
update teachers
set user_id = 3
where id = 2;

insert into cabinets (cabinet, subject_time_id)
values ('B100', 1), ('B100', 2), ('B100', 3), ('B100', 4), ('B100', 5), ('B100', 6), ('B100', 7), ('B100', 8),
       ('B101', 1), ('B101', 2), ('B101', 3), ('B101', 4), ('B101', 5), ('B101', 6), ('B101', 7), ('B101', 8),
       ('B102', 1), ('B102', 2), ('B102', 3), ('B102', 4), ('B102', 5), ('B102', 6), ('B102', 7), ('B102', 8),
       ('B103', 1), ('B103', 2), ('B103', 3), ('B103', 4), ('B103', 5), ('B103', 6), ('B103', 7), ('B103', 8),
       ('B104', 1), ('B104', 2), ('B104', 3), ('B104', 4), ('B104', 5), ('B104', 6), ('B104', 7), ('B104', 8),
       ('B105', 1), ('B105', 2), ('B105', 3), ('B105', 4), ('B105', 5), ('B105', 6), ('B105', 7), ('B105', 8),
       ('B106', 1), ('B106', 2), ('B106', 3), ('B106', 4), ('B106', 5), ('B106', 6), ('B106', 7), ('B106', 8),
       ('B107', 1), ('B107', 2), ('B107', 3), ('B107', 4), ('B107', 5), ('B107', 6), ('B107', 7), ('B107', 8),
       ('B108', 1), ('B108', 2), ('B108', 3), ('B108', 4), ('B108', 5), ('B108', 6), ('B108', 7), ('B108', 8),
       ('B109', 1), ('B109', 2), ('B109', 3), ('B109', 4), ('B109', 5), ('B109', 6), ('B109', 7), ('B109', 8),
       ('B110', 1), ('B110', 2), ('B110', 3), ('B110', 4), ('B110', 5), ('B110', 6), ('B110', 7), ('B110', 8),
       ('B111', 1), ('B111', 2), ('B111', 3), ('B111', 4), ('B111', 5), ('B111', 6), ('B111', 7), ('B111', 8),
       ('B112', 1), ('B112', 2), ('B112', 3), ('B112', 4), ('B112', 5), ('B112', 6), ('B112', 7), ('B112', 8),
       ('B200', 1), ('B200', 2), ('B200', 3), ('B200', 4), ('B200', 5), ('B200', 6), ('B200', 7), ('B200', 8),
       ('B201', 1), ('B201', 2), ('B201', 3), ('B201', 4), ('B201', 5), ('B201', 6), ('B201', 7), ('B201', 8),
       ('B202', 1), ('B202', 2), ('B202', 3), ('B202', 4), ('B202', 5), ('B202', 6), ('B202', 7), ('B202', 8),
       ('B203', 1), ('B203', 2), ('B203', 3), ('B203', 4), ('B203', 5), ('B203', 6), ('B203', 7), ('B203', 8),
       ('B204', 1), ('B204', 2), ('B204', 3), ('B204', 4), ('B204', 5), ('B204', 6), ('B204', 7), ('B204', 8),
       ('B205', 1), ('B205', 2), ('B205', 3), ('B205', 4), ('B205', 5), ('B205', 6), ('B205', 7), ('B205', 8),
       ('B206', 1), ('B206', 2), ('B206', 3), ('B206', 4), ('B206', 5), ('B206', 6), ('B206', 7), ('B206', 8),
       ('B207', 1), ('B207', 2), ('B207', 3), ('B207', 4), ('B207', 5), ('B207', 6), ('B207', 7), ('B207', 8),
       ('B208', 1), ('B208', 2), ('B208', 3), ('B208', 4), ('B208', 5), ('B208', 6), ('B208', 7), ('B208', 8),
       ('B209', 1), ('B209', 2), ('B209', 3), ('B209', 4), ('B209', 5), ('B209', 6), ('B209', 7), ('B209', 8),
       ('B210', 1), ('B210', 2), ('B210', 3), ('B210', 4), ('B210', 5), ('B210', 6), ('B210', 7), ('B210', 8),
       ('B211', 1), ('B211', 2), ('B211', 3), ('B211', 4), ('B211', 5), ('B211', 6), ('B211', 7), ('B211', 8),
       ('B212', 1), ('B212', 2), ('B212', 3), ('B212', 4), ('B212', 5), ('B212', 6), ('B212', 7), ('B212', 8);

insert into subjects (subject, department_id, teacher_id)
values ('CS 101: Programming Languages 1', 1, 1),
       ('CS 102: Programming Languages 2', 1, 1),
       ('CS 203: Web Technologies', 1, 2),
       ('CS 204: Back-end Development with Spring Framework', 1, 2);

insert into schedule (semester, week_day, cabinet_id, group_id, subject_id)
values (false, 'monday', 12, 1, 1),
       (false, 'monday', 10, 1, 2),
       (false, 'monday', 14, 1, 3),
       (false, 'monday', 16, 1, 4);

insert into schedule (semester, week_day, cabinet_id, group_id, subject_id)
values (false, 'tuesday', 12, 1, 1),
       (false, 'tuesday', 10, 1, 2),
       (false, 'tuesday', 14, 1, 3),
       (false, 'tuesday', 16, 1, 4);

insert into schedule (semester, week_day, cabinet_id, group_id, subject_id)
values (false, 'wednesday', 12, 1, 1),
       (false, 'wednesday', 10, 1, 2),
       (false, 'wednesday', 14, 1, 3),
       (false, 'wednesday', 16, 1, 4);

insert into schedule (semester, week_day, cabinet_id, group_id, subject_id)
values (false, 'thursday', 12, 1, 1),
       (false, 'thursday', 10, 1, 2),
       (false, 'thursday', 14, 1, 3),
       (false, 'thursday', 16, 1, 4);

insert into schedule (semester, week_day, cabinet_id, group_id, subject_id)
values (false, 'friday', 12, 1, 1),
       (false, 'friday', 10, 1, 2),
       (false, 'friday', 14, 1, 3),
       (false, 'friday', 16, 1, 4);
