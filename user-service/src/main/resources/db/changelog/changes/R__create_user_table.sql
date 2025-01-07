--liquibase formatted sql

-- changeset liquibase:1 runOnChange:true

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- changeset liquibase:2 runOnChange:true

INSERT INTO users(username, email) values('A', 'A@gmail.com');
INSERT INTO users(username, email) values('B', 'B@gmail.com');
