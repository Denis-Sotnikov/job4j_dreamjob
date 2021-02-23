CREATE TABLE post (
   id SERIAL PRIMARY KEY,
   name TEXT
);
Drop table candidate;
CREATE TABLE candidate (
    id SERIAL PRIMARY KEY,
    name TEXT,
    photoId TEXT
);

CREATE TABLE photo (
    id SERIAL PRIMARY KEY,
    name text
);

CREATE TABLE userForSite (
    id SERIAL PRIMARY KEY,
    name text,
    email text,
    password text
);

CREATE TABLE IF NOT EXISTS city (
   id SERIAL PRIMARY KEY,
   name TEXT
);

INSERT INTO city(name) values ('Sankt-Peterburg');
INSERT INTO city(name) values ('Smolensk');




