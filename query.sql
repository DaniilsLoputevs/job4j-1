create database pruduct_01;

create table type
(
    id_type   serial primary key,
    type_name varchar(100)
);

create table prod
(
    id_prod  serial primary key,
    name     varchar(100),
    type_id  int references type (id_type),
    data_exp timestamp,
    price    int
);

insert into type(type_name) VALUES ('Сыр');
insert into type(type_name) VALUES ('Мороженное');
insert into type(type_name) VALUES ('Молоко');
insert into prod(name, type_id, data_exp, price) VALUES ('мороженное стаканчик',2,'2019-09-17 12:00:00.000000',100);
insert into prod(name, type_id, data_exp, price) VALUES ('мороженное пломбир',2,'2019-09-17 12:00:00.000000',200);
insert into prod(name, type_id, data_exp, price) VALUES ('мороженное сникерс',2,'2019-09-17 12:00:00.000000',300);
insert into prod(name, type_id, data_exp, price) VALUES ('мороженное твикс',2,'2019-09-30 12:00:00.000000',400);
insert into prod(name, type_id, data_exp, price) VALUES ('Сыр гауда',1,'2019-09-30 12:00:00.000000',500);
insert into prod(name, type_id, data_exp, price) VALUES ('Сыр масдам',1,'2019-09-30 12:00:00.000000',1000);
insert into prod(name, type_id, data_exp, price) VALUES ('Молоко обычное',3,'2019-09-30 12:00:00.000000',1000);

/**
  1. Написать запрос получение всех продуктов с типом "СЫР"
 */
select p.name ,p.price from prod as p inner join type as t on p.type_id = t.id_type where t.type_name = 'Сыр';

/**
  2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
 */
select * from prod as p where p.name like '%мороженное%';

/**
  3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
 */
select * from prod as p where p.data_exp >= '2019-08-17 00:00:00' and p.data_exp < '2019-09-18 00:00:00';

/**
  4. Написать запрос, который выводит самый дорогой продукт.
 */
select *from prod order by price desc limit 1;

/**
  5. Написать запрос, который выводит количество всех продуктов определенного типа.
 */

select count(*) from prod as p  where type_id = 1;

/**
  6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
 */

select p.name,t.type_name,p.price from prod as p inner join type as t on p.type_id = t.id_type where t.type_name in ('Сыр','Молоко');

/**
  7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
 */

select type_name from type as t inner join prod p on t.id_type = p.type_id group by t.type_name having count(type_name) <10 ;
/**
  8. Вывести все продукты и их тип.
 */

select * from prod as p inner join type as t on p.type_id = t.id_type group by t.type_name  ;