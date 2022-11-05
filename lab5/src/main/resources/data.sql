insert into address (id, city, street, zip) values (1,'Fairfield','4thN',52557);
insert into users (id, email, first_name, last_name, password, address_id) values (1,'abc@gmail.com', 'ABC','XYZ', '123',1);

insert into category (id, name) values (1,'Chips');
insert into product (id, name, price, rating, category_id) values (1,'Crisps',15.2,4,1);