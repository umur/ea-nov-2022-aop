INSERT INTO public.bi_address (id, city, street, zip) VALUES (1, 'FairField', '1000 N 4th St', '52557');

INSERT INTO public.bi_user (id, email, firstname, lastname, password, address_id) VALUES (1, 'ryan@gmail.com', 'Ryan', 'Long', '12345', 1);

INSERT INTO public.bi_category (id, name) VALUES (1, 'Electronic');

INSERT INTO public.bi_product (id, name, price, rating, category_id) VALUES (2, 'Dell XPS', 2000, 5, 1);

INSERT INTO public.bi_review (id, comment, product_id, user_id) VALUES (1, 'very good', 2, 1);
