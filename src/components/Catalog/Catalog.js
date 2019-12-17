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
    const [selectedLanguages, setSelectedLanguages] = useState([]);
    const [selectedCensorship, setSelectedCensorship] = useState([]);
    const [selectedGenres, setSelectedGenres] = useState([]);

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

    const onChangeLanguage = (checkedValues) => {
        setSelectedLanguages(checkedValues)
    };

    const onChangeCensorhip = (checkedValues) => {
        setSelectedCensorship(checkedValues)
    };

    const onChangeGenre = (checkedValues) => {
        setSelectedGenres(checkedValues)
    };

    const movieFilter = (movie) => {
        let languagePass = true;
        let censorshipPass = true;
        let genresPass = true;
        if (selectedLanguages.length > 0)
            languagePass = selectedLanguages.includes(movie.language.id);
        if (selectedCensorship.length > 0)
            censorshipPass = selectedCensorship.includes(movie.age_censor);
        if (selectedGenres.length > 0)
            genresPass = selectedGenres.some(genre => movie.genreList.map(genre => genre.id).includes(genre));
        return languagePass && censorshipPass && genresPass;
    };

    const movieCards = movies.filter(movieFilter).map(movie => {
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
                    <Filter onChangeLanguage={onChangeLanguage} onChangeCensorhip={onChangeCensorhip} onChangeGenre={onChangeGenre} />
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