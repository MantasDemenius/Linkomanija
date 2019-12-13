import React, {useState} from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Form } from 'antd';
import { Typography } from 'antd';

import PlaceAddForm from './PlaceAddForm';

const WrappedPlaceAddForm = Form.create({ name: 'placeAdd' })(PlaceAddForm);


// dispatch(addQuestion(values));
const { Text } = Typography;
const PlaceAdd = () => {
    return (
        <Card>
            <Text strong>Čia bus vietos pridėjimo forma</Text>
            <WrappedPlaceAddForm/>
        </Card>
    )
}

export default PlaceAdd;