import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Button } from 'antd';
import { Typography } from 'antd';
import { useHistory } from 'react-router-dom';

const { Text } = Typography;
const Darbuotojai = () => {
    let history = useHistory();
    return (<>
        <Card>
            <Text strong>Čia bus darbuotojų sarašas</Text>
        </Card>
        <Card><Text strong>Pridėti darbuotoją</Text> <br/><Button onClick={() =>history.push('/employees/add')}>Pridėti</Button></Card>
        <Card>
            <Text strong>Čia bus darbo grafikas</Text><br/>
            <Button onClick={() =>history.push('/employees/edit')}>Redaguoti</Button>
        </Card></>
    )
}

export default Darbuotojai;