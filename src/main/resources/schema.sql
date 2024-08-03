CREATE TABLE IF NOT EXISTS customer (
    email varchar(100) NOT NULL,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    phone varchar(100) NOT NULL,
    address varchar(100) NOT NULL,
    PRIMARY KEY (email)
);