create table sqlru.public.job
(
    id       SERIAL PRIMARY KEY,

    name_job varchar(10000) not null,

    text     varchar(10000)not null ,

    url      varchar(200) unique,

    data_vac timestamp
);