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


