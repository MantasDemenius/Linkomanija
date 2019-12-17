import React, { useState, useEffect } from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Button } from 'antd';
import { Typography } from 'antd';
import { useParams } from 'react-router-dom';
import { Row, Col } from 'antd';
import { Tag } from 'antd';
import { Select } from 'antd';
import { Form } from 'antd';
import EditMovie from './EditMovie';
import axios from 'axios';

const { Option } = Select;

const { Text } = Typography;
const MovieDetailsPage = () => {
    const [movie, setMovie] = useState({});
    const [rating, setRating] = useState(10);
    console.log(rating);
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

    const handleSubmit = e => {
        e.preventDefault();
        axios.post('/api/movie/rate', {
            rating: rating,
            movie_id: id
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
        window.location.reload();
    }

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
                        <p>Režisierius: <b>{movie.director_list}</b></p>
                        <p>IMDb įvertinimas: <b>{movie.imdb_rating ? movie.imdb_rating : 'N/A'}</b></p>
                        <p>Linkomanija įvertinimas: <b>{movie.user_rating ? Math.round(movie.user_rating * 100) / 100 : 'N/A'}</b></p>
                        <p>Trukmė: <b>{movie.movie_length + 'min'}</b></p>
                        <p>Vaidina: <b>{movie.actor_list}</b></p>
                        {languageTag}
                        {genreTags}
                        <br /><br />
                        <p>{movie.description}</p>
                    </Col>
                </Row>
            </Card>
            <Card>
                <Text strong>Įvertink filmą</Text>
                <Form layout="inline" onSubmit={handleSubmit}>
                    <Form.Item>
                        <Select defaultValue={rating} style={{ width: 120 }} onChange={r => setRating(r)}>
                            <Option value={10}>10</Option>
                            <Option value={9}>9</Option>
                            <Option value={8}>8</Option>
                            <Option value={7}>7</Option>
                            <Option value={6}>6</Option>
                            <Option value={5}>5</Option>
                            <Option value={4}>4</Option>
                            <Option value={3}>3</Option>
                            <Option value={2}>2</Option>
                            <Option value={1}>1</Option>
                            <Option value={0}>0</Option>
                        </Select>
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">Pateikti</Button>
                    </Form.Item>
                </Form>
            </Card>
            <Card>
                <Text strong>Redaguoti filmą</Text>
                <EditMovie />
            </Card>
            <Card>
                <Button>Ištrinti</Button>
            </Card>
        </>
    )
}

export default MovieDetailsPage;