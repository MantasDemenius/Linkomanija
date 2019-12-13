import {
    ADD_CLIENT_SUCCESS,
    ADD_CLIENT_FAILED
  } from '../actionTypes/client';
  const initialState = {
    client: undefined,
    createStatus: undefined,
  };
  
  export default function clientReducer(state = initialState, action) {
    switch (action.type) {
      case ADD_CLIENT_SUCCESS: {
        console.log('success');
        let data = { ...state.employee };
        console.log(data);
        return { ...state, client: data, createStatus: true};
      }
      case ADD_CLIENT_FAILED: {
        console.log('fail');
        return { ...state, createStatus: false };
      }
      default: {
        return state;
      }
    }
  }
  