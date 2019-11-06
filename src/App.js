import React from "react";
import { Layout } from 'antd';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import 'antd/dist/antd.css'
import Navigation from "./components/Navigation/Navigation"
import './App.css'
import Home from "./components/Home"

const { Content, Footer } = Layout;

function Movie() {
  return (<i>Movie</i>)
}

function TimeTable() {
  return (<i>Timetable</i>)
}

const App = () => {
  return (
    <Router>
      <Layout className="layout">
        <Navigation />
        <Content>
          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/movies" component={Movie} />
            <Route path="/timetable" component={TimeTable} />
          </Switch>
        </Content>
        <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
      </Layout>
    </Router>
  )
}

export default App;
