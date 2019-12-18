import React from 'react';
import 'antd/dist/antd.css';
import { Layout, Typography, Form } from 'antd'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
// import './components/User/node_modules/antd/dist/antd.css';
import Navigation from './components/Navigation/Navigation';
import './App.css';
import Home from './components/Home';
import Catalog from './components/Catalog/Catalog';
import LoginPage from './components/Signup/LoginPage';
import SignupPage from './components/Signup/SignupPage';
import MovieDetailsPage from './components/Catalog/MovieDetailsPage';
import SessionPage from './components/Session/SessionPage';
import ProfilePage from './components/Profile/ProfilePage';
import PlacePage from './components/Place/PlacePage';
import ReservationForm from './components/Session/ReservationForm';
import TicketBuyForm from './components/Session/TicketBuyForm';
import EditForm from './components/Session/EditForm';
import SessionAdd from './components/Session/SessionAdd';
import AddMovie from './components/Catalog/AddMovie';
import PlaceAdd from './components/Place/PlaceAdd';
import PlacesEdit from './components/Place/PlacesEdit';
import PlacesDelete from './components/Place/PlacesDelete';
import UserPage from './components/User/UserPage';
import employees from './components/User/darbuotojai';
import EmployeesAdd from './components/User/EmployeesAdd';
import EmployeesEdit from './components/User/EmployeesEdit';
import TicketReserveForm from './components/Session/TicketReserveForm';

const { Content, Footer } = Layout;
const { Text } = Typography;

const App = () => {
  return (
    <Router>
      <Layout className="layout">
        <Navigation />
        <Content>
          <Switch>
            <Route exact path="/" component={SessionPage} />
            <Route exact path="/movies" component={Catalog} />
            <Route path="/prisijungti" component={LoginPage} />
            <Route path="/registracija" component={SignupPage} />
            <Route path="/profile" component={ProfilePage} />
            <Route path="/movies/add" component={AddMovie} />
            <Route path="/movies/:id" component={MovieDetailsPage} />
            <Route path="/patalpa/prideti" component={PlaceAdd} />
            <Route path="/places/edit" component={PlacesEdit} />
            <Route path="/patalpa/panaikinimas" component={PlacesDelete} />
            <Route path="/patalpa" component={PlacePage} />
            <Route path="/naudotojai/darbuotojas/pridėti" component={EmployeesAdd} />
            <Route path="/employees/edit" component={EmployeesEdit} />
            <Route path="/employees" component={employees} />
            <Route path="/naudotojai" component={UserPage} />
            <Route path="/seansas/prideti" component={SessionAdd} />
            <Route path="/seansas/:key/pirkti" component={TicketBuyForm} />
            <Route path="/seansas/:key/rezervuoti" component={TicketReserveForm} />
            <Route path="/seansas/redaguoti/:id" component={EditForm} />
            <Route path="/seansas/:key" component={ReservationForm} />
            {/* <Route path="/timetable" component={TimeTablePage} /> */}
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
