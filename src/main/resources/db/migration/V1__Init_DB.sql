
create sequence hibernate_sequence start 1 increment 1;

create table testing (
    id int8 not null,
    question varchar(255),
    answer boolean,
    user_id int8,
    primary key (id)
);

create table test_result (
    id int8 not null,
    answer boolean,
    primary key (id)
);

create table user_role (
    user_id int8 not null,
    roles varchar(255)
);

create table usr (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);

alter table if exists testing
    add constraint testing_user_fk
    foreign key (user_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;
