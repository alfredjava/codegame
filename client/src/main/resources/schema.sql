CREATE TABLE IF NOT EXISTS person(
                                     id serial not null,
                                     name VARCHAR(200) not null,
                                     gender VARCHAR(60) NOT NULL,
                                     age INTEGER ,
                                     identification VARCHAR(60) ,
                                     address VARCHAR(60) ,
                                     phone VARCHAR(60), PRIMARY KEY (id));