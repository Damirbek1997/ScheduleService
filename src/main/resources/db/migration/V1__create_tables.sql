create table cabinets
(
    id         bigserial    primary key not null,
    cabinet    varchar(255)             not null,
    is_deleted boolean                  default false
);

create table roles
(
    id         bigserial    primary key not null,
    role       varchar(255)             not null,
    is_deleted boolean                  default false
);


create table faculties
(
    id         BIGSERIAL   primary key not null,
    faculty    varchar(250)            not null,
    is_deleted boolean                 default false
);

create table departments
(
    id         BIGSERIAL   primary key not null,
    department varchar(250)            not null,
    faculty_id bigint                            references faculties(id),
    is_deleted boolean                 default false
);

create table groups
(
    id            BIGSERIAL   primary key not null,
    group_name    varchar(250)            not null,
    department_id bigint                            references departments(id),
    is_deleted    boolean                 default false
);

create table teachers
(
    id         BIGSERIAL   primary key not null,
    firstname  varchar(250)            not null,
    lastname   varchar(250)            not null,
    is_deleted boolean                default false
);

create table students
(
    id         BIGSERIAL   primary key not null,
    firstname  varchar(250)            not null,
    lastname   varchar(250)            not null,
    group_id   bigint                            references groups(id),
    is_deleted boolean                 default false
);

create table subjects
(
    id            bigserial    primary key not null,
    subject       varchar(255)             not null,
    department_id bigint                             references departments(id),
    teacher_id    bigint                             references teachers(id),
    is_deleted    boolean                  default false
);

create table schedule
(
    id              bigserial    primary key not null,
    semester        varchar(255)             not null,
    week_day        varchar(255)             not null,
    subject_id      bigint                   not null references subjects(id),
    subject_time_id bigint                   not null references subject_times(id),
    group_id        bigint                            references groups(id),
    cabinet_id      bigint                   not null references cabinets(id),
    is_deleted      boolean                  default  false
);

create table users
(
    id         BIGSERIAL   primary key not null,
    email      varchar(250)             not null,
    password   varchar(250)             not null,
    role_id    bigint                   not null references roles(id),
    student_id bigint                            references students(id) on delete cascade,
    teacher_id bigint                            references teachers(id) on delete cascade,
    is_deleted boolean                  default false
);

alter table teachers
 add column user_id bigint references users(id) on delete cascade;

alter table students
 add column user_id bigint references users(id) on delete cascade;
