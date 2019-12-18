import React from "react";
import '../../App.css'

import { useHistory, Link, Route } from 'react-router-dom';
import { Card, Button, Typography } from 'antd';
import UserList from './UserList';

const { Text } = Typography;

const UserPage = () => {
    let history = useHistory();
    return (
        <>
            <Card>
                <Button onClick={() => history.push('/naudotojai/darbuotojas/pridėti')}>Prideti darbuotoją</Button>
            </Card>
            <Card>
                <h3>Naudotojai</h3>
                <UserList />
            </Card>
        </>
    )
}

export default UserPage;