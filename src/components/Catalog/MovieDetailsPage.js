import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const MovieDetailsPage = () => {
    return (
        <>
            <Card>
                <Text strong>Čia bus filmo aprašymas</Text>
            </Card>
            <Card>
                <Text strong>Čia bus filmo vertinimas</Text>
            </Card>
        </>
    )
}

export default MovieDetailsPage;