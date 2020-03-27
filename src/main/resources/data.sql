-- Hypersonic 2 bootstart DML
insert into author
 (name)
values
 ('George Orwell'),
 ('Graham Hancock')
;

insert into book
(title, isbn)
values
('1984', '88-04-50745-4'),
('Supernatural: Meetings with the Ancient Teachers of Mankind', '1932857400'),
('La fattoria degli animali', '99-00000000-10');
;

INSERT INTO book_author
    (book_id, author_id)
VALUES
    (1, 1)
;