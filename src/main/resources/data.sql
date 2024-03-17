DROP TABLE Products;
CREATE TABLE IF NOT EXISTS Products
(
    ID          int not null AUTO_INCREMENT,
    NAME        varchar(100) not null,
    STATUS      int,
    STOCK       int not null,
    DESCRIPTION varchar(100) not null,
    PRICE       DECIMAL(10, 2) not null,
    DISCOUNT    DECIMAL(10, 2) not null,
    FINAL_PRICE  DECIMAL(10, 2) not null,
    SKU         varchar(100),
    PRIMARY KEY (ID)
);

DELETE Products where id=1;
INSERT INTO Products (NAME, STATUS, STOCK, DESCRIPTION, PRICE, DISCOUNT, FINAL_PRICE, SKU) VALUES ('Gamer Mouse', 0, 10, 'Best mouse ever', 100, 10, 90, 'SKU1234' );