-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS rezervation;
DROP TABLE IF EXISTS "session";
DROP TABLE IF EXISTS timetable;
DROP TABLE IF EXISTS movie_hall;
DROP TABLE IF EXISTS "role";
DROP TABLE IF EXISTS "comment";
DROP TABLE IF exists movie_genre_link;
DROP TABLE IF EXISTS user_employee;
DROP TABLE IF EXISTS email_message;
DROP TABLE IF EXISTS movie_theatre;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS "language";
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS user_client;
DROP TABLE IF EXISTS movie_person;
DROP TABLE IF EXISTS user_admin;
DROP TABLE IF EXISTS role_movie_movie_person_link;
DROP TABLE IF EXISTS "role";

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
	pavadinimas varchar (255) NOT NULL
);

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
	age_censor varchar (255) NOT NULL,
	imdb_code int NOT NULL,
	rating float NOT NULL,
	language_id BIGINT REFERENCES "language" (id)
);

CREATE TABLE prod.movie_theatre
(
	id bigserial NOT null primary key,
	address varchar (255) NOT NULL,
	phone_number varchar (255) NOT NULL,
	creation_date date NOT NULL,
	city_id bigint references "city" (id)
);

INSERT INTO prod.movie_theatre
(address, phone_number, creation_date, city_id)
VALUES('Zirminu 1', '8632213451', current_date, 1);


CREATE TABLE prod.email_message
(
	id bigserial NOT null primary key,
	state boolean NOT NULL,
	description text NOT NULL,
	time_sent timestamp NOT NULL,
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
	born_date date NOT NULL,
	phone_number varchar (255) NOT NULL,
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
	creation_date timestamp NOT NULL,
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
	empty_spaces int NOT NULL,
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
	ticket_state_ boolean NOT NULL,
	user_client_id bigint NOT NULL,
	session_id integer NOT NULL,
	CONSTRAINT fkc_user_client FOREIGN KEY(user_client_id) REFERENCES user_client (id),
	CONSTRAINT fkc_session FOREIGN KEY(session_id) REFERENCES session (id)
);
