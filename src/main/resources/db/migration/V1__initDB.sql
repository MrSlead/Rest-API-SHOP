create table article
(
    id           serial,
    article_name varchar(255),
    content      varchar(3000),
    date         timestamp,
    product_id   int8,
    primary key (id)
);


create table product
(
    id           serial,
    description  varchar(2000),
    product_name varchar(255),
    salary       int4 not null,
    primary key (id)
);

create table product_articles
(
    product_id  int8 not null,
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
