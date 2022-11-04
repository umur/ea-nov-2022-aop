INSERT INTO category (name) VALUES
('Laptop'),('Phone');

INSERT INTO product (name, price, rating, category_id) VALUES
('Macbook', 1000, 4, 1),('XPS', 700, 5, 1),
('Pixel', 500, 5, 2),('Poco', 300, 6, 2);

INSERT INTO address (street, zip, city) VALUES
('1000 N. 4th St.', 52557, 'FairField'),
('New Road', 46557, 'Kathmandu');

INSERT INTO users (email, password, first_name, last_name, address_id) VALUES
('gyawalirajiv@gmail.com', 'pass', 'Rajiv', 'Gyawali', 1),
('sanjiv@gmail.com', 'pass', 'Sanjiv', 'Gyawali', 2);

INSERT INTO review (comment, user_id, product_id) VALUES
('Great Product', 1, 2),
('Good', 1, 1);