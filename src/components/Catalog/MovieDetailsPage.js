import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Button } from 'antd';
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
            <Card>
                <Text strong>Čia bus filmo redagavimo forma</Text>
            </Card>
            <Card>
                <Button>Ištrinti</Button>
            </Card>
        </>
    )
}

export default MovieDetailsPage;