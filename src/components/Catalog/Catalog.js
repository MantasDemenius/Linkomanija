import React, { useEffect, useState } from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import Filter from "./Filter"
import Sorter from "./Sorter"
import MovieCard from "./MovieCard"
import { Row, Col, Card, Button } from 'antd';
import StackGrid, { transitions } from "react-stack-grid";
import { useHistory } from 'react-router-dom';
import axios from 'axios';

const { fadeUp } = transitions;

const Catalog = () => {
    let history = useHistory();
    const [movies, setMovies] = useState([]);
    const [selectedLanguages, setSelectedLanguages] = useState([]);
    const [selectedCensorship, setSelectedCensorship] = useState([]);
    const [selectedGenres, setSelectedGenres] = useState([]);
    const [sortType, setSortType] = useState(0);

    useEffect(() => {
        axios.get('/api/movie')
            .then((res) => {
                setMovies(res.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }, []);

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

    const onSortTypeChange = (e) => {
        setSortType(e.target.value);
    }

    const sortFunction = (sortType) => {
        switch (sortType) {
            case 1:
                return (a, b) => {
                    return a.title.localeCompare(b.title);
                };
            case 2:
                return (a, b) => {
                    return b.title.localeCompare(a.title);
                };
            case 3:
                return (a, b) => {
                    return b.imdb_rating - a.imdb_rating;
                }
            case 4:
                return (a, b) => {
                    return a.imdb_rating - b.imdb_rating;
                }
            default:
                return undefined;
        }
    }

    const movieCards = movies.filter(movieFilter).sort(sortFunction(sortType)).map(movie => {
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
                    <Sorter onChange={onSortTypeChange} />
                    <StackGrid columnWidth={'50%'}
                        monitorImagesLoaded={true}>
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