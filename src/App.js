import React from "react";
import { Route, Link, Switch, BrowserRouter } from "react-router-dom";
import { Menu } from "semantic-ui-react";

import AboutUs from "./components/AboutUs";
const home = () => {
  return <h1>HOME</h1>;
};

function App() {
  return (
    <BrowserRouter>
      <Menu inverted fluid widths={2}>
        <Menu.Item name="Home" as={Link} to="/"></Menu.Item>
        <Menu.Item name="About us" as={Link} to="/about-us"></Menu.Item>
      </Menu>
      <Switch>
        <Route exact path="/" component={home} />
        <Route path="/about-us/" component={AboutUs}></Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
