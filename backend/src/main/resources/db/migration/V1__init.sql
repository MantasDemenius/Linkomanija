CREATE TABLE prod.user_admin
(
	id BIGSERIAL NOT NULL PRIMARY KEY,
	username varchar(255) not null unique,
	password varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	surname varchar(255) NOT NULL,
	born_date date,
	phone_number varchar(255)
);

CREATE TABLE prod.movie_person
(
	id bigserial NOT null primary key,
	name varchar (255) NOT NULL,
	surname varchar (255) NOT NULL
);

CREATE TABLE prod.user_client
(
	id bigserial NOT null primary key,
	username varchar(255) NOT null unique,
	password varchar (255) NOT NULL,
	email varchar (255) NOT NULL,
	name varchar (255) NOT NULL,
	surname varchar (255) NOT NULL,
	born_date date,
	phone_number varchar (255)
);

CREATE TABLE prod.genre
(
	id bigserial NOT null primary key,
	pavadinimas varchar (255) NOT null unique
);

--nesu tikras ar reikia situ ar is imdb ateis
INSERT INTO prod.genre
(pavadinimas)
VALUES('Drama');
INSERT INTO prod.genre
(pavadinimas)
VALUES('Veiksmo');
INSERT INTO prod.genre
(pavadinimas)
VALUES('Trileris');

CREATE TABLE prod.language
(
	id bigserial NOT null primary key,
	name varchar (8) NOT NULL
);
INSERT INTO language(id, name) VALUES(1, 'Lietuvių');
INSERT INTO language(id, name) VALUES(2, 'Anglų');
INSERT INTO language(id, name) VALUES(3, 'Rusų');
INSERT INTO language(id, name) VALUES(4, 'Prancūzų');

CREATE TABLE prod.city
(
	id bigserial NOT null primary key,
	name varchar (8) NOT null unique
);
INSERT INTO city(id, name) VALUES(1, 'Vilnius');
INSERT INTO city(id, name) VALUES(2, 'Kaunas');
INSERT INTO city(id, name) VALUES(3, 'Šiauliai');
INSERT INTO city(id, name) VALUES(4, 'Klaipėda');

CREATE TABLE prod.role
(
	id bigserial NOT null primary key,
	name varchar (11) NOT null unique
);
INSERT INTO role(id, name) VALUES(1, 'Režisierius');
INSERT INTO role(id, name) VALUES(2, 'Aktorius');

CREATE TABLE prod.movie
(
	id bigserial NOT null primary key,
	title varchar (255) NOT NULL,
	poster_url varchar (255) NOT NULL,
	release_date date NOT NULL,
	description text NOT NULL,
	movie_length integer NOT NULL,
	creation_country varchar (255) NULL,
	age_censor varchar (255) NULL,
	imdb_code int NOT NULL,
	rating float NOT NULL,
	language_id BIGINT REFERENCES "language" (id)
);

CREATE TABLE prod.movie_theatre
(
	id bigserial NOT null primary key,
	name varchar(255) not null,
	address varchar (255) NOT NULL,
	phone_number varchar (255) NOT NULL,
	creation_date date NOT null default CURRENT_DATE,
	city_id bigint references "city" (id)
);

INSERT INTO prod.movie_theatre
(name, address, phone_number, city_id)
VALUES('Kauno akropolis "Linkomanija"', 'Kauno akropolis', '8632213451', 2);
INSERT INTO prod.movie_theatre
(name, address, phone_number, city_id)
VALUES('Vilniaus Akropolis "Linkomanija"', 'Vilniaus akropolis', '864554677', 1);
INSERT INTO prod.movie_theatre
(name, address, phone_number, city_id)
VALUES('Šiaulių Akropolis "Linkomanija"', 'Šiaulių akropolis', '864554623', 3);
INSERT INTO prod.movie_theatre
(name, address, phone_number, city_id)
VALUES('Klaipėdos Akropolis "Linkomanija"', 'Klaipėdos akropolis', '864554632', 4);


CREATE TABLE prod.email_message
(
	id bigserial NOT null primary key,
	state boolean NOT NULL,
	description text NOT NULL,
	time_sent timestamp NOT null default current_timestamp,
	user_client_id bigint references user_client (id)
);

CREATE TABLE prod.user_employee
(
	id bigserial NOT null primary key,
	username varchar(255) not null unique,
	password varchar (255) NOT NULL,
	email varchar (255) NOT NULL,
	name varchar (255) NOT NULL,
	surname varchar (255) NOT NULL,
	born_date date,
	phone_number varchar (255),
	movie_theatre_id bigint references movie_theatre (id)
);

CREATE TABLE prod.movie_genre_link
(
	movie_id bigint,
	genre_id bigint,
	primary key(movie_id, genre_id),
	CONSTRAINT fkc_movie FOREIGN KEY(movie_id) REFERENCES movie (id),
	CONSTRAINT fkc_genre FOREIGN KEY(genre_id) REFERENCES genre (id)
);

CREATE TABLE prod.comment
(
	id bigserial NOT null primary key,
	description text NOT NULL,
	creation_date timestamp default current_timestamp,
	user_client_id bigint not null,
	movie_id bigint NOT NULL,
	CONSTRAINT fkc_user_client FOREIGN KEY(user_client_id) REFERENCES user_client (id),
	CONSTRAINT fkc_movie FOREIGN KEY(movie_id) REFERENCES movie (id)
);

CREATE TABLE prod.role_movie_movie_person_link
(
	id bigserial NOT null primary key,
	role_id bigint NOT NULL,
	movie_id bigint NOT NULL,
	movie_person_id bigint NOT NULL,
	FOREIGN KEY(role_id) REFERENCES role (id),
	CONSTRAINT fkc_movie FOREIGN KEY(movie_id) REFERENCES movie (id),
	CONSTRAINT fkc_movie_person FOREIGN KEY(movie_person_id) REFERENCES movie_person (id)
);

CREATE TABLE prod.movie_hall
(
	id bigserial NOT null primary key,
	name varchar (255) NOT NULL,
	column_count int NOT NULL,
	row_count int NOT NULL,
	movie_theatre_id bigint NOT NULL,
	CONSTRAINT fkc_movie_theatre FOREIGN KEY(movie_theatre_id) REFERENCES movie_theatre (id)
);

INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('Scape 1 salė', 8, 20, 1);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('Scape 2 salė', 8, 20, 1);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('3 salė', 6, 15, 1);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('1 salė', 8, 20, 2);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('2 salė', 8, 20, 2);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('3 salė', 6, 15, 2);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('1 salė', 8, 20, 3);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('Scape 1 salė', 8, 20, 3);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('Scape 1 salė', 8, 20, 4);
INSERT INTO prod.movie_hall
("name", column_count, row_count, movie_theatre_id)
VALUES('1 salė', 6, 15, 4);

CREATE TABLE prod.timetable
(
	id bigserial NOT null primary key,
	attending_date date NOT NULL,
	timetable_start timestamp NOT NULL,
	timetable_end timestamp NOT NULL,
	comment varchar(255) NULL,
	user_employee_id bigint NOT NULL,
	CONSTRAINT fkc_user_employee FOREIGN KEY(user_employee_id) REFERENCES user_employee (id)
);

CREATE TABLE prod.session
(
	id bigserial NOT null primary key,
	session_date date NOT NULL,
	session_start varchar (255) NOT NULL,
	session_end varchar (255) NOT NULL,
	empty_spaces int NULL,
	price float NOT NULL,
	length integer NOT NULL,
	language_id bigint NOT NULL,
	movie_id bigint NOT NULL,
	movie_hall_id bigint NOT NULL,
	FOREIGN KEY(language_id) REFERENCES language (id),
	CONSTRAINT fkc_movie FOREIGN KEY(movie_id) REFERENCES movie (id),
	CONSTRAINT fkc_movie_hall FOREIGN KEY(movie_hall_id) REFERENCES movie_hall (id)
);

CREATE TABLE prod.rezervation
(
	id bigserial NOT null primary key,
	creation_date timestamp NOT NULL,
	seat_row int NOT NULL,
	seat_collumn int NOT NULL,
	price float NOT NULL,
	movie_start date NOT NULL,
	movie_end date NOT NULL,
	ticket_state boolean NOT NULL,
	user_client_id bigint NOT NULL,
	session_id integer NOT NULL,
	CONSTRAINT fkc_user_client FOREIGN KEY(user_client_id) REFERENCES user_client (id),
	CONSTRAINT fkc_session FOREIGN KEY(session_id) REFERENCES session (id)
);
