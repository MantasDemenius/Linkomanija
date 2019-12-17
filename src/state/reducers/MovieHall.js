import {
  ADD_MOVIEHALL_FAILED,
  ADD_MOVIEHALL_SUCCESS,
  GET_MOVIEHALL_SUCCESS,
  GET_MOVIEHALL_FAILED,
  DELETE_MOVIEHALL_SUCCESS
} from '../actionTypes/MovieHall';
const initialState = {
  movieHall: undefined,
  error: undefined,
  createStatus: undefined,
};

export default function movieHallReducer(state = initialState, action) {
  switch (action.type) {
    case ADD_MOVIEHALL_SUCCESS: {
      console.log('success');
      return { ...state, createStatus: true};
    }
    case ADD_MOVIEHALL_FAILED: {
      console.log('fail');
      return { ...state, createStatus: false };
    }
    case GET_MOVIEHALL_SUCCESS:{
      console.log("success");
      console.log(action.movieHalls);
      return {...state, movieHall: action.movieHalls }
    }
    case DELETE_MOVIEHALL_SUCCESS:{
      console.log("success");
      return {...state, createStatus: true}
    }
    default: {
      return state;
    }
  }
}
