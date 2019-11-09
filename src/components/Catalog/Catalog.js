import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import Filter from "./Filter"
import Sorter from "./Sorter"
import MovieCard from "./MovieCard"
import { Row, Col } from 'antd';
import StackGrid from "react-stack-grid";

const Catalog = () => {
    return (
        <>
            <Row>
                <Col span={6}>
                    <Filter />
                </Col>
                <Col span={18}>
                    <Sorter />
                    <StackGrid columnWidth={'33.33%'}>
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
                    </StackGrid>
                </Col>
            </Row>
        </>
    )
}

export default Catalog;