insert into genre (id, genre_name) values (6, 'adventure');
insert into genre (id, genre_name) values (7, 'detective');

insert into author (id, first_name, last_name) values (1, 'Agatha', 'Christie');
insert into author (id, first_name, last_name) values (2, 'Walter', 'Scott');
insert into author (id, first_name, last_name) values (6, 'Robert', 'Stevenson');

insert into book (id, name, author_id, genre_id) values (1, 'Five Little Pigs', 1, 7);
insert into book (id, name, author_id, genre_id) values (2, 'The Clocks', 1, 7);
insert into book (id, name, author_id, genre_id) values (3, 'Ivanhoe', 2, 6);
insert into book (id, name, author_id, genre_id) values (7, 'Treasure island', 6, 6);
