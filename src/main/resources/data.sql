--
-- PostgreSQL data dump
--

-- Animal Data insert query
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'), '2020-10-01 08:24:00', 15,'Tiger', '<=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'), '2020-10-30 07:24:00', 20,'Cat', '>=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'), '2020-10-31 07:24:00', 15,'Dog', '<=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-31 07:24:00',	25,	'Elephant',	'>=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-26 07:24:00',	180,'Leo',		'>=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-01 08:24:00',	110,'Bull',		'>=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-01 08:24:00',	12,	'Hippo',	'>=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-30 07:24:00',	10,	'Sheep',	'>=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-10 08:24:00',	6,	'Goat',		'<=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-16 08:24:00',	10,	'Snake',	'<=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-16 08:24:00',	10,	'SnakeDup', '<=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-06 08:24:00',	17,	'Horse',	'>=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-08 08:24:00',	23,	'Donkey',	'<=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-10-09 08:24:00',	13,	'Monkey',	'<=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-11-01 07:24:00',	23,	'Pig',		'<=');
INSERT INTO animal_table(id, located, preference, title, type) VALUES (nextval('animal_generator'),	'2020-11-01 07:24:00',	33,	'Deer',		'>=');

-- Room Data insert query
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-31 08:24:00',	'20',	'Green');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-16 08:24:00',	'5',	'Red');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-16 08:24:00',	'25',	'White');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-15 08:24:00',	'25',	'Grey');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-16 08:24:00',	'5',	'Purple');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-17 08:24:00',	'5',	'Orange');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-16 08:24:00',	'15',	'Blue');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-16 08:24:00',	'10',	'Black');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-10 08:24:00',	'9',	'Brown');
INSERT INTO room_table (id, created, size, title) VALUES (nextval('room_generator'), '2020-10-12 08:24:00',	'90',	'Pink');

-- Favorite Data insert query
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1000, 501);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1001, 500);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1002, 501);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1003, 501);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1004, 503);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1008, 501);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1006, 504);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1007, 505);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1009, 506);
INSERT INTO favorite_table (id, animal_id, room_id) VALUES (nextval('favorite_generator'), 1010, 507);

--
-- PostgreSQL data dump complete
--

