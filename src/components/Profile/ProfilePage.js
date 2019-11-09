import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const ProfilePage = () => {
    return (
        <>
            <Card>
                <Text strong>Čia bus profilio redagavimo forma</Text>
            </Card>
            <Card>
                <Text strong>Čia bus užsakymų istorija</Text>
            </Card>
        </>
    )
}

export default ProfilePage;