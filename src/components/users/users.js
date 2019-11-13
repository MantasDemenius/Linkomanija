import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Button } from 'antd';
import { Typography } from 'antd';
import {useHistory} from 'react-router-dom';

const { Text } = Typography;
const Users = () => {
    let history = useHistory();
    return (
        <Card>
            <Text strong>Čia bus naudotojų sarašas</Text>
            <br/>
            <Button onClick={() => alert("ištrinta")}>Ištrinti</Button>
        </Card>
    )
}

export default Users;