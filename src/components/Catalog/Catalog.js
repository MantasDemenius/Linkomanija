import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import Filter from "./Filter"
import Sorter from "./Sorter"
import Movie from "./Movie"
import { Row, Col } from 'antd';

const Catalog = () => {
    return (
        <>
            <Row>
                <Col span={6}>
                    <Filter />
                </Col>
                <Col span={18}>
                    <Sorter />
                    <Movie />
                </Col>
            </Row>
        </>
    )
}

export default Catalog;