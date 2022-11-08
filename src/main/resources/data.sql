INSERT INTO public.category (name)
VALUES ('HQ');

INSERT INTO public.product (name, price, rating, category_id)
VALUES ('Compass',  2499, 100, 1),
       ('HP Pro',  1799, 90, 1),
       ('HP Lite',  1699, 80, 1),
       ('HP Compass',  1499, 100, 1);

INSERT INTO public.address (city, street, zip)
VALUES ('Fairfield', 'Main', '52556'),
       ('Fairfield', '4th', '52557');

INSERT INTO public.users (email, firstname, lastname, password, address_id)
VALUES ('m1@gmail.com', 'Tri', 'Le', '123', 1),
       ('m2@gmail.com', 'Thomas', 'Alex', '123', 2);

INSERT INTO public.review (comment, product_id, users_id)
VALUES ('Nice product', 1, 1),
       ('It''s too high', 2, 1),
       ('It''s less expensive', 3, 1),
       ('It''s Good lap', 4, 2),
       ('It''s so nice', 1, 2),
       ('It''s great lap as I knew', 2, 2),
       ('It''s perfect', 3, 2),
       ('I love it', 4, 2);
