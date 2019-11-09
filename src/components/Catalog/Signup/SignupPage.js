import React from "react";
import './node_modules/antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const SignupPage = () => {
    return (
        <Card>
            <Text strong>Čia bus registracijos forma</Text>
        </Card>
    )
}

export default SignupPage;