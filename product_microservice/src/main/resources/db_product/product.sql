CREATE TABLE IF NOT EXISTS product (
    product_id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    quantity INTEGER NOT NULL
    );

DROP TABLE product;

CREATE TABLE product (
                         product_id UUID PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         quantity INTEGER NOT NULL
);

ALTER TABLE product ADD COLUMN title VARCHAR(255) NOT NULL;
ALTER TABLE product ADD COLUMN price DECIMAL(10, 2) NOT NULL;
ALTER TABLE product ADD COLUMN quantity INTEGER NOT NULL;