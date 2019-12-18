import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Button } from 'antd';
import { Typography } from 'antd';
import { useHistory } from 'react-router-dom';
import { useSelector } from 'react-redux';
import ProfileEditForm from './ProfileEditForm';

const { Text } = Typography;
const ProfilePage = () => {
    let history = useHistory();
    const content = useSelector(state => state);
    const userId = content.client.userId;
    const userType = content.client.userType;

    return (
        <>
            {userType == "client" ? <ProfileEditForm userId={userId} /> : null}
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