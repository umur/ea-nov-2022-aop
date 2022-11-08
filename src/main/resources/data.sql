
INSERT INTO public.user_info (id, email, first_name, last_name, password) VALUES (3, 'trong@email.com', 'Trong', 'Hoang', '1234');
INSERT INTO public.user_info (id, email, first_name, last_name, password) VALUES (4, 'hoang@email.com', 'Duc', 'Minh', '1234');
INSERT INTO public.address (id, city, street, zip, user_id) VALUES (1, 'Fairfield', '1000 Main St', 52557, 3);
INSERT INTO public.address (id, city, street, zip, user_id) VALUES (2, 'Chicago', '20 North Ave', 32033, 4);
INSERT INTO public.category (id, name) VALUES (5, 'Grocery');
INSERT INTO public.category (id, name) VALUES (6, 'Computer');
INSERT INTO public.category (id, name) VALUES (7, 'Tools');
INSERT INTO public.category (id, name) VALUES (8, 'Foods');
INSERT INTO public.category (id, name) VALUES (9, 'Decorations');
INSERT INTO public.category (id, name) VALUES (10, 'Clothes');
INSERT INTO public.product (id, name, price, rating, category_id) VALUES (11, 'Toilet paper', 5, 4.9, 5);
INSERT INTO public.product (id, name, price, rating, category_id) VALUES (12, 'MacBook Air', 1000, 4.4, 6);
INSERT INTO public.product (id, name, price, rating, category_id) VALUES (13, 'MacBook Pro', 1300, 4.7, 6);
INSERT INTO public.review (id, comment, product_id, user_id) VALUES (14, 'Good computer', 12, 3);
INSERT INTO public.review (id, comment, product_id, user_id) VALUES (15, 'Not bad', 12, 4);
INSERT INTO public.review (id, comment, product_id, user_id) VALUES (16, 'Cheap', 11, 3);
INSERT INTO public.review (id, comment, product_id, user_id) VALUES (17, 'Awesome', 13, 4);
