INSERT INTO address (id, city, street, zip) VALUES ('1', 'Fairfield', 'N 6th St', '52556');

INSERT INTO users (id , email, password, first_name, last_name, address_id) VALUES ('1', 'siam@miu.edu','123456', 'Siam', 'Biswas', '1');

INSERT INTO category (id, name) VALUES ('1', 'Electronics');

INSERT INTO product (id, name, price, rating, category_id) VALUES ('1', 'Macbook Pro', 1500, 5,'1');

INSERT INTO review (id, comment,  user_id, product_id) VALUES ('1','Good product', '1', '1');
