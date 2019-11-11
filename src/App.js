import React from 'react';
import { Layout, Typography } from 'antd';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import 'antd/dist/antd.css';
import Navigation from './components/Navigation/Navigation';
import './App.css';
import Home from './components/Home';
import Catalog from './components/Catalog/Catalog';
import LoginPage from './components/Login/LoginPage';
import SignupPage from './components/Signup/SignupPage';
import MovieDetailsPage from './components/Catalog/MovieDetailsPage';
import TimeTablePage from './components/TimeTable/TimeTablePage';
import ProfilePage from './components/Profile/ProfilePage';
import PlacesPage from './components/Places/PlacesPage';
const { Content, Footer } = Layout;
const { Text } = Typography;

const App = () => {
  return (
    <Router>
      <Layout className="layout">
        <Navigation />
        <Content>
          <Switch>
            <Route exact path="/" component={Home} />
            <Route exact path="/movies" component={Catalog} />
            <Route path="/timetable" component={TimeTablePage} />
            <Route path="/login" component={LoginPage} />
            <Route path="/signup" component={SignupPage} />
            <Route path="/profile" component={ProfilePage} />
            <Route path="/movies/joker" component={MovieDetailsPage} />
            <Route path="/places" component={PlacesPage} />
          </Switch>
        </Content>
        <Footer style={{ textAlign: 'center' }}>
          <Text strong>Linkomanija ©2019, Kaunas</Text>
        </Footer>
      </Layout>
    </Router>
  );
};

export default App;
