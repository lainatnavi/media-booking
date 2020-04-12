-- Hypersonic 2 bootstart DML
insert into author
 (id, name)
values
 (1,'George Orwell'),
 (2,'Graham Hancock')
;

insert into book
(id,title, isbn)
values
(1,'1984', '88-04-50745-4'),
(2,'Supernatural: Meetings with the Ancient Teachers of Mankind', '1932857400'),
(3,'La fattoria degli animali', '99-00000000-10');
;

INSERT INTO book_author
    (book_id, author_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 1)
;