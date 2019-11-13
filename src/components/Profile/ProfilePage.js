import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Button } from 'antd';
import { Typography } from 'antd';
import {useHistory} from 'react-router-dom';

const { Text } = Typography;
const ProfilePage = () => {
    let history = useHistory();
    return (
        <>
            <Card>
                <Text strong>Čia bus profilio redagavimo forma</Text>
                {/* <Button onClick={() => history.push('/')}>Pridėti</Button> */}
            </Card>
            
            <Card>
                <Text strong>Čia bus užsakymų istorija</Text>
            </Card>
            <Card>
                <Text strong>Čia bus darbo grafiko langas </Text>
            </Card>
        </>
    )
}

export default ProfilePage;