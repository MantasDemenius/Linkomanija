import { put, all, takeLatest } from 'redux-saga/effects';

import {
    ADD_EMPLOYEE,
    ADD_EMPLOYEE_FAILED,
    ADD_EMPLOYEE_SUCCESS,
} from '../actionTypes/Employee';

import { RESPONSE_STATUS, getRequest, postRequest, putRequest } from '../../common/ApiRequests';
import {ADD_EMPLOYEE_ROUTE} from '../../common/Routes';

function* addEmployee(action) {
  console.log("saga", action.formData);
  const { status, data } = yield postRequest(ADD_EMPLOYEE_ROUTE, action.formData);
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
