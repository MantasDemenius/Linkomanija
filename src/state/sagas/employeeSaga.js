import { put, all, takeLatest } from 'redux-saga/effects';

import {
    ADD_EMPLOYEE,
    ADD_EMPLOYEE_FAILED,
    ADD_EMPLOYEE_SUCCESS,
} from '../actionTypes/Employee';

import { RESPONSE_STATUS, getRequest, postRequest, putRequest } from '../../common/ApiRequests';

function* addEmployee(action) {
  console.log("saga", action.formData);
  const { status, data } = yield postRequest(`users/employees`, action.formData);
  console.log(data);
  switch (status) {
    case RESPONSE_STATUS.OK:
      yield put({ type: ADD_EMPLOYEE_SUCCESS, newMovieHall: data });
      break;
    default:
      yield put({ type: ADD_EMPLOYEE_FAILED });
  }
}

function* actionWatcher() {
  yield takeLatest(ADD_EMPLOYEE, addEmployee);
}

export function* employeeSaga() {
  yield all([actionWatcher()]);
}
