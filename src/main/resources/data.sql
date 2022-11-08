INSERT INTO public.categories(name) VALUES('grocery');
INSERT INTO public.categories(name) VALUES('electronics');

INSERT INTO public.products(name, price,rating) VALUES('bottle', 200,9.0);
INSERT INTO public.products(name, price, rating) VALUES('noodles', 300, 8);

INSERT INTO public.users(email, password,firstName,lastName) VALUES('john@miu.edu','Admin@123','John','Jlname');
INSERT INTO public.users(email, password,firstName,lastName) VALUES('harry@miu.edu','Admin@123','Harry','Halname');

INSERT INTO public.reviews(comment) VALUES('excellent and long lasting');
INSERT INTO public.reviews(comment) VALUES('not good');