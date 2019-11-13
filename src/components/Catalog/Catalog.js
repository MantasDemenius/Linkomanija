import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import Filter from "./Filter"
import Sorter from "./Sorter"
import MovieCard from "./MovieCard"
import { Row, Col, Card, Button } from 'antd';
import StackGrid from "react-stack-grid";
import {useHistory} from 'react-router-dom';

const Catalog = () => {
    let history = useHistory();
    return (
        <>
            <Row>
                <Col span={6}>
                    <Filter />
                </Col>
                <Col span={18}>
                    <Sorter />
                    <StackGrid columnWidth={'50%'}>
                        <MovieCard
                            poster="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png"
                            title="Džokeris"
                            description="2019"
                            to="/movies/joker"
                        />
                        <MovieCard
                            poster="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png"
                            title="Džokeris"
                            description="2019"
                            to="/movies/joker"
                        />
                        <MovieCard
                            poster="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png"
                            title="Džokeris"
                            description="2019"
                            to="/movies/joker"
                        />
                        <Card>
                        <Button onClick={() =>history.push('/movies/add')}>Pridėti</Button>
                        </Card>
                    </StackGrid>
                </Col>
            </Row>
        </>
    )
}

export default Catalog;