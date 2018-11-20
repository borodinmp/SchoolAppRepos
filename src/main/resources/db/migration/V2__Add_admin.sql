insert into usr (id, username, password, full_name, active)
    values (0, 'admin', '123', 'Иванов Иван Иванович', true);

insert into user_role (user_id, roles)
    values (0, 'USER'), (0, 'ADMIN');