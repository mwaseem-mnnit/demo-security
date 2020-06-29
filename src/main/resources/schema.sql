drop table if exists TRANSACTIONS;
drop table if exists authority;
drop table if exists user;
create table user
(
    id       integer      not null primary key auto_increment,
    username varchar(50)  not null unique ,
    password varchar(80)  not null,
    email    varchar(100) not null,
    enabled  boolean      not null
);

create table authority
(
    id      integer not null primary key auto_increment,
    user_id integer not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_user foreign key (user_id) references user (id)
);
create unique index ix_auth_username on authority (id, authority);
CREATE TABLE IF NOT EXISTS TRANSACTIONS
(
    id       INT not null PRIMARY KEY auto_increment,
    username VARCHAR(30),
    coin     VARCHAR(3),
    type     VARCHAR(5),
    quantity DECIMAL,
    price    DECIMAL
);