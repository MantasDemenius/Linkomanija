import React, {useState} from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography } from 'antd';

import PlaceAddForm from './PlaceAddForm';

const { Text } = Typography;
const PlaceAdd = () => {
    return (
        <Card >
            <Text strong>Pridėti vietą</Text>
            <PlaceAddForm/>
        </Card>
    )
}

export default PlaceAdd;