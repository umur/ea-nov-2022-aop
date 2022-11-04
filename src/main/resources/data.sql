/*select * from product;*/

INSERT into category (id, name) values (1, 'Category 1');
INSERT into category (id, name) values (2, 'Category 2');
INSERT into category (id, name) values (3, 'Category 3');
INSERT into category (id, name) values (4, 'Category 4');
INSERT into category (id, name) values (5, 'Category 5');

INSERT into address (id, city, street, zip_code) values (1, 'City 1', 'Street 1', 50201);
INSERT into address (id, city, street, zip_code) values (2, 'City 2', 'Street 2', 50202);
INSERT into address (id, city, street, zip_code) values (3, 'City 3', 'Street 3', 50203);
INSERT into address (id, city, street, zip_code) values (4, 'City 4', 'Street 4', 50204);
INSERT into address (id, city, street, zip_code) values (5, 'City 5', 'Street 5', 50205);

INSERT into user1 (id, email,first_name,last_name, password, address_id) values (1, 'admin@localhost', 'admin', 'admin', 'admin', 1);
INSERT into user1 (id, email,first_name,last_name, password, address_id) values (2, 'user@localhost', 'user', 'user', 'user', 2);
INSERT into user1 (id, email,first_name,last_name, password, address_id) values (3, 'user1@localhost', 'user1', 'user1', 'user1', 3);
INSERT into user1 (id, email,first_name,last_name, password, address_id) values (4, 'user2@localhost', 'user2', 'user2', 'user2', 4);
INSERT into user1 (id, email,first_name,last_name, password, address_id) values (5, 'user3@localhost', 'user3', 'user3', 'user3', 5);

INSERT into product (id, name, price, rating, category_id) values (1, 'Product 1', 100, 4, 1);
INSERT into product (id, name, price, rating, category_id) values (2, 'Product 2', 200, 3, 1);
INSERT into product (id, name, price, rating, category_id) values (3, 'Product 3', 300, 5, 1);
INSERT into product (id, name, price, rating, category_id) values (4, 'Product 4', 400, 2, 1);
INSERT into product (id, name, price, rating, category_id) values (5, 'Product 5', 500, 1, 1);
INSERT into product (id, name, price, rating, category_id) values (6, 'Product 6', 600, 4, 1);
INSERT into product (id, name, price, rating, category_id) values (7, 'Product 7', 700, 3, 1);
INSERT into product (id, name, price, rating, category_id) values (8, 'Product 8', 800, 5, 1);


INSERT into review (id, comment,product_id, user_id) values (1, 'Comment 1', 1, 1);
INSERT into review (id, comment,product_id, user_id) values (2, 'Comment 2', 2, 2);
INSERT into review (id, comment,product_id, user_id) values (3, 'Comment 3', 3, 3);
INSERT into review (id, comment,product_id, user_id) values (4, 'Comment 4', 4, 4);
INSERT into review (id, comment,product_id, user_id) values (5, 'Comment 5', 5, 5);
INSERT into review (id, comment,product_id, user_id) values (6, 'Comment 6', 6, 1);
INSERT into review (id, comment,product_id, user_id) values (7, 'Comment 7', 1, 2);
INSERT into review (id, comment,product_id, user_id) values (8, 'Comment 8', 2, 3);
INSERT into review (id, comment,product_id, user_id) values (9, 'Comment 9', 3, 4);
INSERT into review (id, comment,product_id, user_id) values (10, 'Comment 10', 4, 5);
INSERT into review (id, comment,product_id, user_id) values (11, 'Comment 11', 5, 1);
