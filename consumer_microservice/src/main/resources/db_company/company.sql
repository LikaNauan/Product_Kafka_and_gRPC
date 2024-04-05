DROP TABLE company;

CREATE TABLE IF NOT EXISTS company (
                                       company_id UUID PRIMARY KEY,
                                       company VARCHAR(255) NOT NULL,
                                       product_id UUID NOT NULL REFERENCES product(product_id)
);