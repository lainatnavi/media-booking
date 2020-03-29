-- Hypersonic 2 Bootstrap DDL

--ALTER SEQUENCE HIBERNATE_SEQUENCE RESTART WITH 1;

drop table if exists book_author;
create table book_author (
    book_id int,
    author_id int,
    unique key (book_id, author_id)
);

drop table if exists author;
create table author (
    id int auto_increment primary key,
    name varchar(250)
);

drop table if exists book;
create table book (
    id int auto_increment primary key,
    title varchar(250) not null,
    isbn varchar(250) not null unique
);





