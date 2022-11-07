
-- tbl_user

INSERT INTO tbl_user (fld_email, fld_password, fld_firstname, fld_lastname)
VALUES ('diptesh.shrestha@miu.edu', 'Dip123', 'Diptesh', 'Shrestha');

INSERT INTO tbl_user (fld_email, fld_password, fld_firstname, fld_lastname)
VALUES ('santosh.manandhar@miu.edu', 'San123', 'Santosh', 'Manandhar');

INSERT INTO tbl_user (fld_email, fld_password, fld_firstname, fld_lastname)
VALUES ('bipul.ranjitkar@miu.edu', 'Bip123', 'Bipul', 'Ranjitkar');

INSERT INTO tbl_user (fld_email, fld_password, fld_firstname, fld_lastname)
VALUES ('sunit.bajracharya@miu.edu', 'Sun123', 'Sunit', 'Bajracharya');

-- tbl_address

INSERT INTO tbl_address (fld_city, fld_street, fld_zip, fld_user_id_fk)
VALUES ('Fairfield', '1000N 4th St', '52557', (SELECT fld_user_id FROM tbl_user WHERE fld_email = 'santosh.manandhar@miu.edu'));

INSERT INTO tbl_address (fld_city, fld_street, fld_zip, fld_user_id_fk)
VALUES ('Fairfield', '507 W Burlington Ave', '52557', (SELECT fld_user_id FROM tbl_user WHERE fld_email = 'bipul.ranjitkar@miu.edu'));

INSERT INTO tbl_address (fld_city, fld_street, fld_zip, fld_user_id_fk)
VALUES ('Fairfield', '104 W Adams Ave', '52557', (SELECT fld_user_id FROM tbl_user WHERE fld_email = 'sunit.bajracharya@miu.edu'));

INSERT INTO tbl_address (fld_city, fld_street, fld_zip, fld_user_id_fk)
VALUES ('Fairfield', '117 N Court St', '52557', (SELECT fld_user_id FROM tbl_user WHERE fld_email = 'diptesh.shrestha@miu.edu'));

-- tbl_category

INSERT INTO tbl_category (fld_category_name)
VALUES ('Sports');

INSERT INTO tbl_category (fld_category_name)
VALUES ('Electronics');

INSERT INTO tbl_category (fld_category_name)
VALUES ('Groceries');

INSERT INTO tbl_category (fld_category_name)
VALUES ('Clothing');

-- tbl_product

INSERT INTO tbl_product (fld_product_name, fld_price, fld_rating, fld_category_id_fk)
VALUES ('Mac Pro 14 inch.', 1849, 9.0, (SELECT fld_category_id FROM tbl_category WHERE fld_category_name = 'Electronics'));

INSERT INTO tbl_product (fld_product_name, fld_price, fld_rating, fld_category_id_fk)
VALUES ('Blue Medium Polo Shirt', 28, 5.75, (SELECT fld_category_id FROM tbl_category WHERE fld_category_name = 'Clothing'));

INSERT INTO tbl_product (fld_product_name, fld_price, fld_rating, fld_category_id_fk)
VALUES ('Football Shoes Size 42', 80, 6.5, (SELECT fld_category_id FROM tbl_category WHERE fld_category_name = 'Sports'));

INSERT INTO tbl_product (fld_product_name, fld_price, fld_rating, fld_category_id_fk)
VALUES ('Planters Mixed Nuts 500gm', 9, 4.25, (SELECT fld_category_id FROM tbl_category WHERE fld_category_name = 'Groceries'));

-- tbl_review

INSERT INTO tbl_review (fld_comment, fld_user_id_fk, fld_product_id_fk)
VALUES ('Average quality and not very delicious', (SELECT fld_user_id FROM tbl_user WHERE fld_email = 'bipul.ranjitkar@miu.edu'), (SELECT fld_product_id FROM tbl_product WHERE fld_product_name = 'Planters Mixed Nuts 500gm'));

INSERT INTO tbl_review (fld_comment, fld_user_id_fk, fld_product_id_fk)
VALUES ('Okay and comfortable', (SELECT fld_user_id FROM tbl_user WHERE fld_email = 'sunit.bajracharya@miu.edu'), (SELECT fld_product_id FROM tbl_product WHERE fld_product_name = 'Football Shoes Size 42'));

INSERT INTO tbl_review (fld_comment, fld_user_id_fk, fld_product_id_fk)
VALUES ('Good style and fitting', (SELECT fld_user_id FROM tbl_user WHERE fld_email = 'diptesh.shrestha@miu.edu'), (SELECT fld_product_id FROM tbl_product WHERE fld_product_name = 'Blue Medium Polo Shirt'));

INSERT INTO tbl_review (fld_comment, fld_user_id_fk, fld_product_id_fk)
VALUES ('Excellent device', (SELECT fld_user_id FROM tbl_user WHERE fld_email = 'santosh.manandhar@miu.edu'), (SELECT fld_product_id FROM tbl_product WHERE fld_product_name = 'Mac Pro 14 inch.'));
