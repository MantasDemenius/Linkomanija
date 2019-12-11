import React from "react";
import '../../App.css'

import {useHistory, Link, Route} from 'react-router-dom';
import { Card, Button, Typography } from 'antd';

const { Text } = Typography;



const UserPage = () => {
    let history = useHistory();
    return (
        <>
        <Card>
        <Button onClick={() =>history.push('/naudotojai/darbuotojas/pridėti')}>Prideti darbuotoją</Button>
            <Text strong>Čia bus naudotojų sarašas</Text>
            <br/>
            <Button onClick={() => alert("ištrinta")}>Ištrinti</Button>
        </Card>
        </>
    )
}

export default UserPage;