import React from "react"
import { Card } from 'antd';

const { Meta } = Card;

const Movie = (props) => {
    return (
        <Card
            hoverable
            style={{ width: 240 }}
            cover={<img alt="example" src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" />}
        >
            <Meta title="Džokeris" description="2019" />
        </Card>
    )
}

export default Movie;