CREATE TABLE IF NOT EXISTS Products (
                                        ID int not null AUTO_INCREMENT,
                                        NAME varchar(100) not null,
    STATUS int,
    PRIMARY KEY ( ID )
    );


INSERT INTO Products (NAME, STATUS) VALUES ('Gamer Mouse', 0);
INSERT INTO Products (NAME, STATUS) VALUES ('HyperX Keyboard', 0);
