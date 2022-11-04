-- Add category
INSERT INTO category (name) VALUES ('IPad');
INSERT INTO category (name) VALUES ('IPhone');
INSERT INTO category (name) VALUES ('Cat');
INSERT INTO category (name) VALUES ('Dog');


INSERT INTO product (name, price, rating, category_id) VALUES ('IPad Pro', 699.90, 4, 1);
INSERT INTO product (name, price, rating, category_id) VALUES ('IPad Air', 799.90, 4, 1);

INSERT INTO product (name, price, rating, category_id) VALUES ('IPhone11', 899.90, 4, 2);
INSERT INTO product (name, price, rating, category_id) VALUES ('IPhone12', 999.90, 5, 2);
INSERT INTO product (name, price, rating, category_id) VALUES ('IPhone13', 1099.90, 5, 2);
INSERT INTO product (name, price, rating, category_id) VALUES ('IPhone14', 1199.90, 5, 2);

INSERT INTO product (name, price, rating, category_id) VALUES ('Cat food 1', 9.90, 4, 3);
INSERT INTO product (name, price, rating, category_id) VALUES ('Cat food 2', 19.90, 4, 3);

INSERT INTO product (name, price, rating, category_id) VALUES ('Dog food 1', 9.90, 4, 4);
INSERT INTO product (name, price, rating, category_id) VALUES ('Dog food 2', 19.90, 4, 4);

-- REVIEW
INSERT INTO address(id, city, street, zip) VALUES (1, 'Fairfield', 'Main', 52556);

INSERT INTO uzer(id, email, first_name, last_name, password, address_id) VALUES (1, 'user1@mail.com', 'Hash', 'Gear', 'pass1', 1);
INSERT INTO uzer(id, email, first_name, last_name, password, address_id) VALUES (2, 'user2@mail.com', 'Josh', 'Paul', 'pass1', 1);

INSERT INTO review (id, comment, product_id, uzer_id) VALUES (1, 'very nice phone', 3, 1);
INSERT INTO review (id, comment, product_id, uzer_id) VALUES (2, 'bad phone', 3, 2);
