-- Hypersonic 2 Bootstrap DDL

drop table book_author;
create table book_author (
    book_id number(10,0),
    author_id number(10,0),
    unique (book_id, author_id)
);

drop table author;
create table author (
    id number(10,0) primary key,
    name varchar2(255) not null
);
drop sequence AUTHOR_SEQ_GEN;
create sequence AUTHOR_SEQ_GEN
    minvalue 1
    maxvalue 9999999999
    start with 1
    increment by 100
    cache 100;

drop table book;
create table book (
    id number(10,0) primary key,
    title varchar2(255) not null,
    isbn varchar2(255) not null unique
);
drop sequence BOOK_SEQ_GEN;
create sequence BOOK_SEQ_GEN
    minvalue 1
    maxvalue 9999999999
    start with 1
    increment by 100
    cache 100;






