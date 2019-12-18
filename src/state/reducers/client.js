import {
  ADD_CLIENT_SUCCESS,
  ADD_CLIENT_FAILED,
  USER_LOGIN_FAILED,
  USER_LOGIN_SUCCESS,
  CREATE_STATUS_REMOVE
} from '../actionTypes/client';
const initialState = {
  client: undefined,
  userType: 'admin',
  userId: 1,
  createStatus: undefined,
};

export default function clientReducer(state = initialState, action) {
  switch (action.type) {
    case ADD_CLIENT_SUCCESS: {
      console.log('success');
      let data = { ...state.employee };
      console.log(data);
      return { ...state, client: data };
    }
    case ADD_CLIENT_FAILED: {
      console.log('fail');
      return { ...state };
    }
    case USER_LOGIN_SUCCESS: {
      console.log(action.newClient);
      return { ...state, userType: action.newClient.role, createStatus: true, userId: action.newClient.userClient.id };
    }
    case USER_LOGIN_FAILED: {
      console.log("fail");
      return { ...state, createStatus: false };
    }
    case CREATE_STATUS_REMOVE: {
      return { client: undefined, createStatus: undefined, userType: '' }
    }
    default: {
      return state;
    }
  }
}
