-- Data For Category

INSERT  INTO  Category (name) VALUES ('Electronics');
INSERT  INTO  Category (name) VALUES ('Plants');
INSERT  INTO  Category (name) VALUES ('Foods');

--Data For Product

INSERT INTO Product(name,price,rating,category_id) VALUES ('Phones',200,2.5,1);
INSERT INTO Product(name,price,rating,category_id) VALUES ('Laptop',400,5,1);

INSERT INTO Product(name,price,rating,category_id) VALUES ('Cactus',100,3.5,2);
INSERT INTO Product(name,price,rating,category_id) VALUES ('Marigold',600,4.5,2);

INSERT INTO Product(name,price,rating,category_id) VALUES ('Lays',800,1.5,3);
INSERT INTO Product(name,price,rating,category_id) VALUES ('Noodles',1000,2.5,3);

--Data for User
INSERT INTO Users(email,password,firstName,lastName) VALUES ('abhay.rawal@miu.edu','xxxx','Abhay','Rawal');
INSERT INTO users(email,password,firstName,lastName) VALUES ('adarsh.rawal@miu.edu','xxxx','Adarsh','Rawal');

--Data for Address
INSERT INTO Address(street,zip,city,user_id) VALUES ('10NTH','1432','FairField',1);
INSERT INTO Address(street,zip,city,user_id) VALUES ('110STH','9123','Kathmandu',2);





--Data for Review

INSERT INTO Review(comment,user_id,product_id) VALUES ('Good!',1,1);
INSERT INTO Review(comment,user_id,product_id) VALUES ('Wow!',2,2);


