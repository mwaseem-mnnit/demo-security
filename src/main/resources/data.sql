INSERT into user (id, username, password, email, enabled) values (1, 'admin','{noop}god','admin@gmail.com',true);
INSERT into user (id, username, password, email, enabled) values (2, 'user','{noop}password','user@gmail.com',true);
INSERT into user (id, username, password, email, enabled) values (3, 'snakamoto','{noop}bitcoin','snakamoto@gmail.com',true);
INSERT into authority (user_id, authority) values (1,'ADMIN');
INSERT into authority (user_id, authority) values (2,'USER');
INSERT into authority (user_id, authority) values (2,'USER');
INSERT into TRANSACTIONS (id, username, coin, type, quantity, price) values (1, 'user', 'BTC', 'BUY',1,5000);
INSERT into TRANSACTIONS (id, username, coin, type, quantity, price) values (2, 'user', 'BTC', 'BUY',3.5,5500);
INSERT into TRANSACTIONS (id, username, coin, type, quantity, price) values (3, 'user', 'LTC', 'BUY',100,50);
INSERT into TRANSACTIONS (id, username, coin, type, quantity, price) values (4, 'user', 'BTC', 'BUY',0.5,4000);
INSERT into TRANSACTIONS (id, username, coin, type, quantity, price) values (5, 'user', 'LTC', 'BUY',31,70);
INSERT into TRANSACTIONS (id, username, coin, type, quantity, price) values (6, 'user', 'BTC', 'BUY',4,5000);