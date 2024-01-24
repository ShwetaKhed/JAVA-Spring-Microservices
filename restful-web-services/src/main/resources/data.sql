insert into  user_details(id, birth_date, name)
values (10001, current_date(), 'Shweta');

insert into  user_details (id, birth_date, name)
values (10002, current_date(), 'Mireya');

insert into  post (id, desc, user_id)
values (20001, 'My Love', 10002);

insert into  post (id, desc, user_id)
values (20002, 'Meeee', 10001);