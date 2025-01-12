--liquibase formatted sql

-- changeset liquibase:1 runOnChange:true

CREATE TABLE if not exists orders(
        id SERIAL PRIMARY KEY,
        item_name VARCHAR(255),
        item_category VARCHAR(255),
        item_description VARCHAR(255)
);



CREATE TABLE if not exists user_order_mapping(
        id SERIAL PRIMARY KEY,
        user_id_fk INT,
        order_id_fk INT,
        FOREIGN KEY(order_id_fk) REFERENCES orders(id)
);

