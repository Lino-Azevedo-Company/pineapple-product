CREATE TABLE pna_product (
    product_id      INTEGER AUTO_INCREMENT NOT NULL,
    name            VARCHAR(200) NOT NULL,
    descr           VARCHAR(4000),
    descr_add       VARCHAR(4000),
    model           VARCHAR(200) NOT NULL,
    price           DECIMAL(10, 2) NOT NULL,
    discount        DECIMAL(10, 2),
    weight          DECIMAL(5,3),
    dimensions      VARCHAR(8),
    packing_weight  DECIMAL(5,3),
    packing_dim     VARCHAR(8),
    active          BOOLEAN
);

ALTER TABLE pna_product
    ADD CONSTRAINT pna_product_pk PRIMARY KEY (product_id);
