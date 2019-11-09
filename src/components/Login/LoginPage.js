import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const LoginPage = () => {
    return (
        <Card>
            <Text strong>Čia bus prisijungimo forma</Text>
        </Card>
    )
}

export default LoginPage;