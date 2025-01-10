--liquibase formatted sql

-- changeset liquibase:1 runOnChange:true

CREATE TABLE if not exists users(
        id SERIAL PRIMARY KEY,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists department (
        id SERIAL PRIMARY KEY,
        departmentName VARCHAR(255) NOT NULL,
        userIdFK INT,
        FOREIGN KEY(userIdFK) REFERENCES users(id)
);

ALTER TABLE users
ADD COLUMN testColumn VARCHAR(255)