ALTER TABLE prod.rezervation
ALTER COLUMN creation_date TYPE date,
ALTER COLUMN movie_start TYPE timestamp,
ALTER COLUMN movie_end TYPE timestamp,
ALTER COLUMN session_id TYPE bigint;

ALTER TABLE prod.movie
ALTER COLUMN imdb_code TYPE varchar(32);




