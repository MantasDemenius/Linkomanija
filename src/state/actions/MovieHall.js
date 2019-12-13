import {
  ADD_MOVIEHALL,
} from '../actionTypes/MovieHall';

export const addMovieHall = (formData) => ({
  type: ADD_MOVIEHALL,
  formData,
});

