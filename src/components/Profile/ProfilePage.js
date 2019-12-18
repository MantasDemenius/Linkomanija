import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { useSelector } from 'react-redux';
import ProfileEditForm from './ProfileEditForm';
import Orders from './Orders';
import Timetable from './Timetable';

const ProfilePage = () => {
    const content = useSelector(state => state);
    const userId = content.client.userId;
    const userType = content.client.userType;

    return (
        <>
            {userType == "client" ? <ProfileEditForm userId={userId} /> : null}
            {userType == "client" ? <Orders userId={userId} /> : null}
            {userType == "employee" ? <Timetable userId={userId} /> : null}
        </>
    )
}

export default ProfilePage;