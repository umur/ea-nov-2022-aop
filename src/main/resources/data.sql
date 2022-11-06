-- address
INSERT INTO address(city, street, zip) VALUES ('Fairfield', 'Main', 52556);
INSERT INTO address(city, street, zip) VALUES ('Fairfield', 'North', 52556);
INSERT INTO address(city, street, zip) VALUES ('Ottumwa', 'Main', 52555);
-- user
INSERT INTO user1(email, first_name, last_name, password, address_id) VALUES ('user1@mail.com', 'John', 'Lennon', 'F1000', 1);
INSERT INTO user1(email, first_name, last_name, password, address_id) VALUES ('user2@mail.com', 'Ann', 'Marie', 'F1002', 2);
INSERT INTO user1(email, first_name, last_name, password, address_id) VALUES ('user3@mail.com', 'Josh', 'Bush', 'F1003', 3);
--category
INSERT INTO category(name) VALUES ('Laptop');
INSERT INTO category(name) VALUES ('Phone');
INSERT INTO category(name) VALUES ('Other');
--product
INSERT INTO product(name, price, rating, cat_id) VALUES ('Dell', 1000, 4, 1);
INSERT INTO product(name, price, rating, cat_id) VALUES ('Lenovo', 980, 3, 1);
INSERT INTO product(name, price, rating, cat_id) VALUES ('Macbook pro', 1999, 5, 1);
INSERT INTO product(name, price, rating, cat_id) VALUES ('Iphone X', 1400, 5, 2);
INSERT INTO product(name, price, rating, cat_id) VALUES ('Samsung A30', 600, 4, 3);
-- review
INSERT INTO review(comment, product_id, user1_id) VALUES ('Dell was very nice', 1, 1);
INSERT INTO review(comment, product_id, user1_id) VALUES ('Lenovo was very bad!!!', 2, 1);
INSERT INTO review(comment, product_id, user1_id) VALUES ('Macbook pro was very nice', 3, 2);
INSERT INTO review(comment, product_id, user1_id) VALUES ('Iphone X was very nice', 4, 2);
INSERT INTO review(comment, product_id, user1_id) VALUES ('Samsung A30 was very nice', 5, 3);
