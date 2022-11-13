INSERT INTO public.category (name)
VALUES ('Apple');

INSERT INTO public.product (name, price, rating, category_id)
VALUES ('Macbook Pro M1',  2499, 100, 1),
       ('Macbook Air M2',  1499, 90, 1),
       ('Macbook Air M1',  1299, 80, 1),
       ('Macbook Pro 13 inch M2',  1799, 100, 1);

INSERT INTO public.address (city, street, zip)
VALUES ('Fairfield', 'Main', '52556'),
       ('Fairfield', '4th', '52557');

INSERT INTO public.user_info (email, first_name, lastname, password, address_id)
VALUES ('abc@gmail.com', 'Ba Luan', 'Tran', '123', 1),
       ('qwe@gmail.com', 'Thomas', 'Tran', '123', 2);

UPDATE public.address SET user_id = 1 WHERE id = 1;
UPDATE public.address SET user_id = 2 WHERE id = 2;

INSERT INTO public.review (comment, product_id, user_id)
VALUES ('Good product', 1, 1),
       ('It''s expensive', 2, 1),
       ('It''s less expensive than the latest model and more than fast enough for the things most people use a computer for—web browsing, working on documents, coding, and light photo and video editing', 3, 1),
       ('It''s Good laptop', 4, 2),
       ('It''s exciting', 1, 2),
       ('It''s good computer', 2, 2),
       ('It''s perfect', 3, 2),
       ('I''m very like it', 4, 2);
