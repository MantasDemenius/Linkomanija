import React from "react";
import { Carousel } from 'antd';
import 'antd/dist/antd.css'
import '../App.css'

const Home = () => {
    return (
        <Carousel autoplay>
            <div>
                <h3>1</h3>
            </div>
            <div>
                <h3>2</h3>
            </div>
            <div>
                <h3>3</h3>
            </div>
            <div>
                <h3>4</h3>
            </div>
        </Carousel>
    )
}

export default Home;
