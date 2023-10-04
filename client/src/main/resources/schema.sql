CREATE TABLE IF NOT EXISTS person(
                                     person_id serial not null,
                                     name VARCHAR(200) not null,
                                     gender CHAR(1) NOT NULL,
                                     age SMALLINT ,
                                     identification VARCHAR(30) NOT NULL UNIQUE,
                                     address VARCHAR(60) ,
                                     phone VARCHAR(60), PRIMARY KEY (person_id));

CREATE TABLE IF NOT EXISTS client(
                                     client_id serial not null,
                                     password VARCHAR(200)  ,
                                     status BOOLEAN DEFAULT false,
                                     person_id INTEGER ,
                                     FOREIGN KEY (person_id) REFERENCES person(person_id));

