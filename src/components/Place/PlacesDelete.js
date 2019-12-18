import React, { useEffect, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card, Button } from 'antd';
import { Typography } from 'antd';
import { useHistory } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { getMovieHall, deleteMovieHall } from '../../state/actions/MovieHall';
import { Select } from 'antd';

const { Option } = Select;
const { Title } = Typography;

const { Text } = Typography;
const PlacesDelete = () => {
  const dispatch = useDispatch();
  let history = useHistory();
  const movieHall = useSelector((store) => store.MovieHall.movieHall);

  useEffect(() => {
    dispatch(getMovieHall());
  }, []);

  function handleChange(value) {
      dispatch(deleteMovieHall(value));
      history.push('/patalpa');
  }

  if(movieHall === undefined){
      console.log(movieHall);
      return null;
  }
  return (
    <Card>
        <Title level={2}>Pasirinkite salę kurią norite ištrinti</Title>
      <Select style={{ width: '100%' }} onChange={handleChange}>
          {movieHall !== undefined && movieHall.map((hall) => 
              <Option key={hall.id} value={hall.id}>{`${hall.movieTheatre.name} ${hall.name}`}</Option>
          )}
      </Select>
      {/* <Button onClick={() =>history.push('/movies/add')}>Pridėti</Button> */}
    </Card>
  );
};

export default PlacesDelete;
