create database sql_first_task;
/**
  Отношение многие к одному
  many users one role
 */
create table users
(
    id_user   serial primary key,
    name      varchar(20),
    last_name varchar(20),
    role_id   integer references role (id_role)

);

create table role
(
    id_role   serial primary key,
    name_role varchar(20)
);
/**
  Инициализация данных в таблице role , user , item
 */
insert into users(name, last_name, role_id)
values ('Sergey', 'Bolshanin', 1);
insert into users(name, last_name, role_id)
values ('Alex', 'Alexan', 2);
insert into role(name_role)
values ('root');
insert into role(name_role)
values ('student');
insert into items(name_task, id_user)
values ('Check', 1);
insert into items(name_task, id_user)
values ('Check2', 2);


/**
  Связывание many to many на примере таблицы role and rules

 */
create table rules
(
    id_rules   serial primary key,
    name_rules varchar(60)
);

create table role_rules
(
    id_role_rules serial primary key,
    id_rules      int references rules (id_rules),
    id_role       int references role (id_role)
);
/**
  таблица заявок отображающая связь
  * many item one user
  * many items one category

 */
create table items
(
    id_item       serial primary key,
    name_task     varchar(100),
    id_user       int references users (id_user),
    name_category int references category (id_category),
    state_item    int references state (id_state)

);
/**
  таблица коментариев к заявке отображающая связь
  * one item many comments
 */
create table comments
(
    id_comments      serial primary key,
    description_task varchar(1000),
    id_item          int references items (id_item)
);

create table category
(
    id_category   serial primary key,
    name_category varchar(20)
);
/**
  таблица вложенных материалов оторбражающая связь
  * one item many attach
 */
create table attach
(
    id      serial primary key,
    file    varchar(100),
    id_item int references items (id_item)
);
/**
  таблица state отображение
  * many items to one
 */
create table state
(
    id_state  serial primary key,
    name_stat varchar(20)
);
