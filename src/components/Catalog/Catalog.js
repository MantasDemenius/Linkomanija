import React, { useEffect, useState } from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import Filter from "./Filter"
import Sorter from "./Sorter"
import MovieCard from "./MovieCard"
import { Row, Col, Card, Button } from 'antd';
import StackGrid from "react-stack-grid";
import { useHistory } from 'react-router-dom';
import axios from 'axios';

const Catalog = () => {
    let history = useHistory();
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        axios.get('/api/movie')
            .then((res) => {
                setMovies(res.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }, []);
    console.log(movies);

    const movieCards = movies.map(movie => {
        return (
            <MovieCard
                key={movie.id}
                movie={movie}
            />
        );
    });

    return (
        <>
            <Row>
                <Col span={6}>
                    <Filter />
                </Col>
                <Col span={18}>
                    <Sorter />
                    <StackGrid columnWidth={'50%'}>
                        {movieCards}
                        <Card>
                            <Button onClick={() => history.push('/movies/add')}>Pridėti</Button>
                        </Card>
                    </StackGrid>
                </Col>
            </Row>
        </>
    )
}

export default Catalog;