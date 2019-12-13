import {
  ADD_EMPLOYEE_SUCCESS,
  ADD_EMPLOYEE_FAILED
} from '../actionTypes/Employee';
const initialState = {
  employee: undefined,
  createStatus: undefined,
};

export default function employeeReducer(state = initialState, action) {
  switch (action.type) {
    case ADD_EMPLOYEE_SUCCESS: {
      console.log('success');
      let data = { ...state.employee };
      return { ...state, employee: data, createStatus: true};
    }
    case ADD_EMPLOYEE_FAILED: {
      console.log('fail');
      return { ...state, createStatus: false };
    }
    default: {
      return state;
    }
  }
}
