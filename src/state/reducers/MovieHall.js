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
      return {...state, movieHall: action.movieHalls }
    }
    case DELETE_MOVIEHALL_SUCCESS:{
      console.log("success");
      const data = { ...state.movieHall};
      let id;
      let incId = 0;
      data.push(null);
      console.log(data);
      data.forEach((item) => {
        if (item.id === action.hallId) {
          id = incId;
        } else {
          incId = incId + 1;
        }
      });
      data.splice(id, 1);
      return {...state, createStatus: true}
    }
    default: {
      return state;
    }
  }
}
