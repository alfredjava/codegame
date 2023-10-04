DROP TABLE IF EXISTS person;
CREATE TABLE person(
                      person_id uuid DEFAULT random_uuid() PRIMARY KEY,
                      name VARCHAR(200) not null,
                      gender VARCHAR(60) NOT NULL,
                      age INTEGER ,
                      identification VARCHAR(60) ,
                      address VARCHAR(60) ,
                      phone VARCHAR(60)
);

