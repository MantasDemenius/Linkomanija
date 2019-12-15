CREATE TABLE prod.movie_user_rating
(
	id bigserial NOT null primary key,
	rating float NOT NULL,
	movie_id bigint references "movie" (id)
);

ALTER TABLE prod.movie
ADD COLUMN imdb_last_updated Date,
ADD COLUMN user_rating float,
RENAME COLUMN rating imdb_rating;
