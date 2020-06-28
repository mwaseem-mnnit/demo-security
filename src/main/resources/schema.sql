drop table if exists TRANSACTIONS;
drop table if exists authorities;
drop table if exists users;
create table users
(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(50) not null,
    email   varchar(100) not null,
    enabled boolean      not null
);

create table authorities
(
    username varchar_ignorecase(50) not null primary key,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);
create unique index ix_auth_username on authorities (username, authority);
CREATE TABLE IF NOT EXISTS TRANSACTIONS
(
    id       INT PRIMARY KEY,
    username VARCHAR(30),
    coin     VARCHAR(3),
    type     VARCHAR(5),
    quantity DECIMAL,
    price    DECIMAL
);