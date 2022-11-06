/*INSERT INTO products (id,description,price,name) VALUES (1,'desc1',1.00,'ipad');
INSERT INTO products(id,description,price,name) VALUES (2,'desc2','2.00','iphone');*/

 insert into addresses (street,zip,city) values('4th','52557','Fairfield')
insert into addresses (street,zip,city) values('8th','52888','Burlington')
 insert into addresses (street,zip,city) values('11th','45676','Ottumwa')

insert into categories(name) values('Electrical')
 insert into categories(name) values('Food')
 insert into categories(name) values('Software')

insert into customers(email,password,first_name,last_name,address_id) values('issetimba@gmail.com','1234','Iga','Daniel',2)
 insert into customers(email,password,first_name,last_name,address_id) values('katuturenatah68@gmail.com','123456','Katutu','Renatah',1)
 insert into customers(email,password,first_name,last_name,address_id) values('kasozisam13@gmail.com','5776','Kasozi','Samuel',3)

 INSERT INTO products(name,price,rating,category_id) VALUES ('Electric Kettle',15.56,4,1)
 INSERT INTO products(name,price,rating,category_id) VALUES ('Corn Flakes',17.47,5,2)
 INSERT INTO products(name,price,rating,category_id) VALUES ('Windows 11',100.98,4,3)

INSERT INTO reviews(comment,customer_id,product_id) VALUES('GOOD','2',3)
 INSERT INTO reviews(comment,customer_id,product_id) VALUES('FAIR','2',1)
 INSERT INTO reviews(comment,customer_id,product_id) VALUES('POOR','1',1)
 INSERT INTO reviews(comment,customer_id,product_id) VALUES('GOOD','3',2)