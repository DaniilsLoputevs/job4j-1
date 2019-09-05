
create table tracker.public.items (
                       id serial primary key ,

                        name varchar (200) not null ,

                        description varchar (200),

                        created timestamp ,

                        comments varchar (1000)
);