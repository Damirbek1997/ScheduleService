insert into faculties (faculty)
values ('Faculty of Engineering and Informatics'), ('Faculty of Social Sciences'), ('Faculty of Economics and Administrative Sciences');

insert into departments (department, faculty_id)
values ('Computer of Science', 1), ('Electronics and Nanoelectronics Engineering', 1), ('Applied Mathematics & Informatics', 1),
       ('Translation and Translation Studies (English Language', 2), ('Philology (English Language and Literature)', 2), ('Psychology', 2), ('Pedagogy (Elementary School Teaching)', 2), ('Journalism', 2),
       ('Economics (International Economics and Business)', 3), ('International Relations', 3), ('Management', 3), ('Economics (Finance and Credit)', 3), ('International Law', 3);

insert into groups (group_name, department_id)
values ('COM-17b', 1), ('ELN-17b', 2), ('AMI-17b', 3), ('TTSe-17b', 4), ('PHe-17b', 5), ('PSC-17b', 6), ('PST-17b', 7), ('JRN-17b', 8), ('ECN-17b', 9), ('INR-17b', 10), ('MAN-17b', 11), ('ECNf-17b', 12), ('INL-17b', 13);

insert into roles (role)
values ('ROLE_ADMIN'), ('ROLE_TEACHER'), ('ROLE_STUDENT');

insert into teachers (firstname, lastname, is_deleted)
values ('Ruslan', 'Isaev', false), ('Burul', 'Shambetova', false);

insert into users (email, password, role_id, teacher_id, student_id)
values ('admin', 'admin', 1, null, null), ('teacher', 'ruslan', 2, 1, null), ('teacher2', 'burul', 2, 2, null);

update teachers
set user_id = 1 where id = 1;
update teachers
set user_id = 2 where id = 2;

insert into cabinets (cabinet)
values ('B100'), ('B101'), ('B102'), ('B103'), ('B104'), ('B105'), ('B106'), ('B107'), ('B108'), ('B109'), ('B110'), ('B111'), ('B112'), ('B200'), ('B201'), ('B202'), ('B203'), ('B204'), ('B205'), ('B206'), ('B207'), ('B208'), ('B209'), ('B210'), ('B211'), ('B212');

insert into subjects (subject, department_id, teacher_id)
values ('CS 101: Programming Languages 1', 1, 1), ('CS 102: Programming Languages 2', 1, 1), ('CS 203: Web Technologies', 1, 2), ('CS 204: Back-end Development with Spring Framework', 1, 2);

insert into schedule (semester, week_day, cabinet_id, group_id, subject_id, subject_time_id)
values (false, 'monday', 12, 1, 1, 1), (false, 'monday', 10, 1, 2, 3), (false, 'monday', 14, 1, 3, 5), (false, 'monday', 16, 1, 4, 7);
