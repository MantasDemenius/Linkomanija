import React from "react";
import { Menu, Layout } from 'antd';
import { Link, withRouter, useHistory } from "react-router-dom";
import PropTypes from 'prop-types';
import 'antd/dist/antd.css'
import '../../App.css'
import { useDispatch, useSelector } from 'react-redux';
import {removeCreateStatus} from '../../state/actions/client'
const { Header } = Layout;

const Navigation = ({ location }) => {
    const user = useSelector((store) => store.client.userType);
    const dispatch = useDispatch();
    const history = useHistory();
    const handleLogout = () => {
        dispatch(removeCreateStatus());
        history.push('/');
    }
    return (
        <Header style={{ background: "#fff" }}>
            <Link to="/" >
                <div className="logo" >
                    LOGO
                </div>
            </Link>
            <Menu
                theme="light"
                mode="horizontal"
                defaultSelectedKeys={[location.pathname]}
                style={{ lineHeight: '64px' }}
            >
                {/* <Menu.Item key="/timetable">
                    <Link to="/timetable" />
                    <span>Repertuaras</span>
                </Menu.Item> */}
                <Menu.Item key="/movies">
                    <Link to="/movies" />
                    <span>Filmai</span>
                </Menu.Item>
                <Menu.Item key="/patalpa">
                    <Link to="/patalpa" />
                    <span>Kino teatrai</span>
                </Menu.Item>
                {user === 'admin' &&
                <Menu.Item key="/naudotojai">
                    <Link to="/naudotojai" />
                    <span>Naudotojai</span>
                </Menu.Item>}
                {user === '' &&
                <Menu.Item key="/prisijungti">
                    <Link to="/prisijungti" />
                    <span>Prisijungti</span>
                </Menu.Item>}
                {user === '' &&
                <Menu.Item key="/registracija">
                    <Link to="/registracija" />
                    <span>Registruotis</span>
                </Menu.Item>}
                {user !== 'admin' && user !== '' &&
                <Menu.Item key="/profile">
                    <Link to="/profile" />
                    <span>Mano Profilis</span>
                </Menu.Item>}
                {user !== '' &&
                <Menu.Item key="logout" onClick={handleLogout}>
                    <span>Atsijungti</span>
                </Menu.Item>}
                
            </Menu>
        </Header>
    )
}

Navigation.propTypes = {
    location: PropTypes.object.isRequired,
}

export default withRouter(Navigation);