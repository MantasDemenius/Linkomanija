import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const PlacesPage = () => {
    return (
        <Card>
            <Text strong>Čia bus galima peržiūrėti visas patalpas</Text>
        </Card>
    )
}

export default PlacesPage;