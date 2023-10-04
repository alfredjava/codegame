CREATE TABLE IF NOT EXISTS person(
                                     person_id serial not null,
                                     name VARCHAR(200) not null,
                                     gender VARCHAR(60) NOT NULL,
                                     age INTEGER ,
                                     identification VARCHAR(60) ,
                                     address VARCHAR(60) ,
                                     phone VARCHAR(60), PRIMARY KEY (person_id));

CREATE TABLE IF NOT EXISTS client(
                                     client_id serial not null,
                                     password VARCHAR(200)  ,
                                     status VARCHAR(20) ,
                                     person_id INTEGER ,
                                     FOREIGN KEY (person_id) REFERENCES person(person_id));

