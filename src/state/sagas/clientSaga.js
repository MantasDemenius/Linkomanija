import { put, all, takeLatest } from 'redux-saga/effects';

import {
    ADD_CLIENT,
    ADD_CLIENT_SUCCESS,
    ADD_CLIENT_FAILED,
} from '../actionTypes/client';

import {ADD_CLIENT_ROUTE} from '../../common/Routes';

import { RESPONSE_STATUS, getRequest, postRequest, putRequest } from '../../common/ApiRequests';

function* addClient(action) {
  console.log("saga", action.formData);
  const { status, data } = yield postRequest(ADD_CLIENT_ROUTE, action.formData);
  switch (status) {
    case RESPONSE_STATUS.OK:
      yield put({ type: ADD_CLIENT_SUCCESS, newClient: data });
      break;
    default:
      yield put({ type: ADD_CLIENT_FAILED });
  }
}

function* actionWatcher() {
  yield takeLatest(ADD_CLIENT, addClient);
}

export function* clientSaga() {
  yield all([actionWatcher()]);
}
