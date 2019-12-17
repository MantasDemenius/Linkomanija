import React, { useState, useEffect } from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Button } from 'antd';
import { Typography } from 'antd';
import { useParams } from 'react-router-dom';
import { Row, Col } from 'antd';
import { Tag } from 'antd';
import axios from 'axios';

const { Text } = Typography;
const MovieDetailsPage = () => {
    const [movie, setMovie] = useState({});
    let { id } = useParams();
    console.log(movie);

    useEffect(() => {
        axios.get('/api/movie/' + id)
            .then((res) => {
                setMovie(res.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }, []);

    let languageTag = null;
    if (movie.language)
        languageTag = ((languageId) => {
            console.log(languageId)
            switch (languageId) {
                case 1:
                    return (<Tag color="blue">LT</Tag>);
                case 2:
                    return (<Tag color="blue">EN</Tag>);
                case 3:
                    return (<Tag color="blue">RU</Tag>);
                default:
                    return (<Tag color="blue">LT</Tag>);
            }
        })(movie.language.id);

    let genreTags = [];
    if (movie.genreList)
        genreTags = movie.genreList.map((genre) => {
            return (<Tag color="blue">{genre.pavadinimas}</Tag>)
        })

    return (
        <>
            <Card>
                <Row>
                    <Col span={12}>
                        <img src={movie.poster_url} />
                    </Col>
                    <Col span={12}>
                        <h2><b>{movie.title}</b></h2>
                        <p>Premjera: <b>{movie.release_date ? movie.release_date.substring(0, 10) : ''}</b></p>
                        <p>Režisierius: <b>{movie.director}</b></p>
                        <p>IMDb įvertinimas: <b>{movie.imdb_rating ? movie.imdb_rating : 'N/A'}</b></p>
                        <p>Linkomanija įvertinimas: <b>{movie.user_rating ? movie.user_rating : 'N/A'}</b></p>
                        <p>Trukmė: <b>{movie.movie_length + 'min'}</b></p>
                        {languageTag}
                        {genreTags}
                    </Col>
                </Row>
            </Card>
            <Card>
                <p>{movie.description}</p>
            </Card>
            <Card>
                <Text strong>Čia bus filmo redagavimo forma</Text>
            </Card>
            <Card>
                <Button>Ištrinti</Button>
            </Card>
        </>
    )
}

export default MovieDetailsPage;