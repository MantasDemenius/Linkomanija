import { combineReducers } from 'redux';

import MovieHall from './MovieHall';
import Employee from './Employee';
import client from './client';

export default combineReducers({
  MovieHall,
  Employee,
  client,
});
