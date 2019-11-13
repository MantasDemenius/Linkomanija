import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Button } from 'antd';
import { Typography } from 'antd';
import {useHistory} from 'react-router-dom';

const { Text } = Typography;
const PlacesAdd = () => {
    let history = useHistory();
    return (
        <Card>
            <Text strong>Čia bus vietos pridėjimo forma</Text>
            {/* <Button onClick={() =>history.push('/movies/add')}>Pridėti</Button> */}
        </Card>
    )
}

export default PlacesAdd;