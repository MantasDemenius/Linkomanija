import React from "react";
import { Menu, Layout } from 'antd';
import { Link, withRouter } from "react-router-dom";
import PropTypes from 'prop-types';
import 'antd/dist/antd.css'
import '../../App.css'

const { Header } = Layout;

const Navigation = ({ location }) => {
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
                <Menu.Item key="/places">
                    <Link to="/places" />
                    <span>Patalpos</span>
                </Menu.Item>
                <Menu.Item key="/naudotojai">
                    <Link to="/naudotojai" />
                    <span>Naudotojai</span>
                </Menu.Item>
                <Menu.Item key="/login">
                    <Link to="/login" />
                    <span>Prisijungti</span>
                </Menu.Item>
                <Menu.Item key="/signup">
                    <Link to="/signup" />
                    <span>Registruotis</span>
                </Menu.Item>
                <Menu.Item key="/profile">
                    <Link to="/profile" />
                    <span>Mano Profilis</span>
                </Menu.Item>
                
            </Menu>
        </Header>
    )
}

Navigation.propTypes = {
    location: PropTypes.object.isRequired,
}

export default withRouter(Navigation);