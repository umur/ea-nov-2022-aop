INSERT INTO address (city, street, zipcode) VALUES ('Fairfield', 'N 6th St', '52556');

INSERT INTO users (email, first_name, last_name, password, address_id) VALUES ('saintur.batkhuu@miu.edu', 'Saintur', 'Batkhuu', 'Password', 1);

INSERT INTO category (name) VALUES ('Electronics');

INSERT INTO product (name, price, rating, category_id) VALUES ('Macbook Pro', 1500, 5, 1);

INSERT INTO review (comment, user_id, product_id) VALUES ('Good product', 1, 1);

