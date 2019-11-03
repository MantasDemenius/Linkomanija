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
        <Menu.Item name="Home" as={Link} to="Linkomanija/"></Menu.Item>
        <Menu.Item name="About us" as={Link} to="Linkomanija/about-us"></Menu.Item>
      </Menu>
      <Switch>
        
        <Route path="Linkomanija/about-us/" component={AboutUs}></Route>
        <Route path="Linkomanija/" component={home} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
