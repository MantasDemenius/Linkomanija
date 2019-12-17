import {
  ADD_MOVIEHALL,
  GET_MOVIEHALL,
  DELETE_MOVIEHALL
} from '../actionTypes/MovieHall';

export const addMovieHall = (formData) => ({
  type: ADD_MOVIEHALL,
  formData,
});
export const getMovieHall = () => ({
  type: GET_MOVIEHALL
});
export const deleteMovieHall = (id) => ({
  type: DELETE_MOVIEHALL,
  id,
});

