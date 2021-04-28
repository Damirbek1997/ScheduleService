create table schedule_time
(
    id   BIGSERIAL   primary key not null,
    time varchar(50)             not null
);

insert into schedule_time (time)
values ('09:00 am - 09:45 am'),
       ('09:45 am - 10:30 am'),
       ('10:40 am - 11:25 am'),
       ('11:25 am - 12:10 pm'),
       ('01:30 pm - 02:15 pm'),
       ('02:15 pm - 03:00 pm'),
       ('03:10 pm - 03:55 pm'),
       ('03:55 pm - 04:30 pm');
