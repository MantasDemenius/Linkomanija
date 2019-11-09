import React from "react"
import { Card } from 'antd';
import { Link } from 'react-router-dom';

const { Meta } = Card;

const MovieCard = ({ poster, title, description, to }) => {
    return (
        <Link to={to}>
            <Card
                hoverable
                cover={<img alt="example" src={poster} />}
            >
                <Meta title={title} description={description} />
            </Card>
        </Link>
    )
}

export default MovieCard;