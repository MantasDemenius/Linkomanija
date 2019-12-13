import {
  ADD_MOVIEHALL_FAILED,
  ADD_MOVIEHALL_SUCCESS
} from '../actionTypes/MovieHall';
const initialState = {
  movieHall: undefined,
  hasCode: undefined,
  joinSessionError: undefined,
  isLoading: undefined,
  error: undefined,
  createStatus: undefined,
};

export default function movieHallReducer(state = initialState, action) {
  switch (action.type) {
    case ADD_MOVIEHALL_SUCCESS: {
      console.log('success');
      let data = { ...state.movieHall };
      return { ...state, movieHall: data};
    }
    case ADD_MOVIEHALL_FAILED: {
      console.log('fail');
      return { ...state, createStatus: false };
    }
    default: {
      return state;
    }
  }
}
