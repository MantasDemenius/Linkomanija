import React from "react"
import { Card } from 'antd';
import { Link } from 'react-router-dom';
import { Tag } from 'antd';

const { Meta } = Card;

const MovieCard = ({ movie }) => {

    const censorTag = ((censor) => {
        switch (censor) {
            case 'N-7':
                return (<Tag color="gold">{movie.age_censor}</Tag>);
            case 'N-13':
                return (<Tag color="volcano">{movie.age_censor}</Tag>);
            case 'N-16':
                return (<Tag color="red">{movie.age_censor}</Tag>);
            default:
                return (<Tag color="green">{movie.age_censor}</Tag>);
        }
    })(movie.age_censor);

    let genreTags = [];
    if (movie)
        genreTags = movie.genreList.map((genre) => {
            return (<Tag color="blue">{genre.pavadinimas}</Tag>)
        })

    const description = (
        <>
            <div>
                {censorTag}
                {genreTags}
            </div>
        </>
    );

    return (
        <Link to={"/movies/" + movie.id}>
            <Card
                hoverable
                cover={<img src={movie.poster_url} />}
            >
                <Meta title={movie.title} description={description} />
            </Card>
        </Link>
    )
}

export default MovieCard;