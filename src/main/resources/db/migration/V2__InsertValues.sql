INSERT INTO product
VALUES (1, 'description', 'Apple mobile', 7500);
INSERT INTO product
VALUES (2, 'description', 'Android mobile', 3000);
INSERT INTO product
VALUES (3, 'description', 'PC', 10000);
INSERT INTO product
VALUES (4, 'description', 'Laptop', 10000);


INSERT INTO article
VALUES (1, 'About Android N2', 'here is the content', '2020-10-08 21:11:11', 2);
INSERT INTO article
VALUES (2, 'About Android N1', 'here is the content', '2020-10-08 20:00:00', 2);
INSERT INTO article
VALUES (3, 'About PC N1', 'here is the content', '2020-10-08 22:22:33', 3);
INSERT INTO article
VALUES (4, 'About Laptop N1', 'here is the content', '2020-10-08 21:22:33', 3);

SELECT pg_get_serial_sequence('product', 'id');
ALTER SEQUENCE product_id_seq RESTART WITH 5;

SELECT pg_get_serial_sequence('article', 'id');
ALTER SEQUENCE article_id_seq RESTART WITH 5;
