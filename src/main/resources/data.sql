insert into genre (id, genre_name, genre_key) values (1, 'fiction', 'f');
insert into genre (id, genre_name, genre_key) values (4, 'tale', 't');
insert into genre (id, genre_name, genre_key) values (5, 'classic', 'c');
insert into genre (id, genre_name, genre_key) values (6, 'adventure', 'a');
insert into genre (id, genre_name, genre_key) values (7, 'detective', 'd');

insert into author (id, first_name, last_name) values (1, 'Agatha', 'Christie');
insert into author (id, first_name, last_name) values (2, 'Walter', 'Scott');
insert into author (id, first_name, last_name) values (3, 'Honore', 'de Balzac');
insert into author (id, first_name, last_name) values (4, 'Isaac', 'Asimov');
insert into author (id, first_name, last_name) values (5, 'Alexander', 'Pushkin');
insert into author (id, first_name, last_name) values (6, 'Robert', 'Stevenson');

insert into book (id, name, author_id, genre_id) values (1, 'Five Little Pigs', 1, 7);
insert into book (id, name, author_id, genre_id) values (2, 'The Clocks', 1, 7);
insert into book (id, name, author_id, genre_id) values (3, 'Ivanhoe', 2, 6);
insert into book (id, name, author_id, genre_id) values (4, 'Eugenie Grandet', 3, 5);
insert into book (id, name, author_id, genre_id) values (5, 'I am Robot', 4, 1);
insert into book (id, name, author_id, genre_id) values (6, 'Tail of the fisherman and the fish', 5, 4);
insert into book (id, name, author_id, genre_id) values (7, 'Treasure island', 6, 6);

insert into comment (id, book_id, comment_text) values (1, 3, 'My favorite romantic novel.');
insert into comment (id, book_id, comment_text) values (2, 7, 'Is it real story? I saw  series about Flint and his crew named The Pirates. This movie looks close to real life');

