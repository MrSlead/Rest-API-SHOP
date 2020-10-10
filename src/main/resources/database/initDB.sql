create table article (
        id serial,
        article_name varchar(255),
        content varchar(3000),
        date timestamp,
        product_id int8,
        primary key (id)
);


   create table product (
        id serial,
        description varchar(2000),
        product_name varchar(255),
        salary int4 not null,
        primary key (id)
);

    create table product_articles (
       product_id int8 not null,
        articles_id int8 not null
);


    alter table if exists product_articles
       add constraint UK_8tleigdirhjxcia35m4hhwnya unique (articles_id);

    alter table if exists article
       add constraint FKbxy24ht14wxvuhu2fo3w4de3b
       foreign key (product_id)
       references product;

    alter table if exists product_articles
       add constraint FKc6wbhpm48r7oj2hojltgf4a9g
       foreign key (articles_id)
       references article;

    alter table if exists product_articles
       add constraint FK18qu1i56gdqqad63k0fm9e2v1
       foreign key (product_id)
       references product;


INSERT INTO product VALUES (1, 'description', 'Apple mobile', 7500);
INSERT INTO product VALUES (2, 'description', 'Android mobile', 3000);
INSERT INTO product VALUES (3, 'description', 'PC', 10000);


INSERT INTO article VALUES (1, 'About Android N1', 'here is the content', '2020-10-08 20:00:00', 2);
INSERT INTO article VALUES (2, 'About Android N2', 'here is the content', '2020-10-08 21:11:11', 2);
INSERT INTO article VALUES (3, 'About PC N1', 'here is the content', '2020-10-08 22:22:33', 3);