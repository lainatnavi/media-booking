drop table if exists book;

create table book (
    id int auto_increment primary key,
    name varchar(250) not null,
    author varchar(250),
    isbn varchar(250) not null
);

