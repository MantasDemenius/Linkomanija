import { put, all, takeLatest } from 'redux-saga/effects';

import {
  ADD_MOVIEHALL,
  ADD_MOVIEHALL_SUCCESS,
  ADD_MOVIEHALL_FAILED,
} from '../actionTypes/MovieHall';

import { RESPONSE_STATUS, getRequest, postRequest, putRequest } from '../../common/ApiRequests';
import {ADD_MOVIEHALL_ROUTE} from '../../common/Routes';

function* addMovieHall(action) {
  console.log("saga", action.formData);
  const { status, data } = yield postRequest(ADD_MOVIEHALL_ROUTE, action.formData);
  console.log(data);
  switch (status) {
    case RESPONSE_STATUS.OK:
      yield put({ type: ADD_MOVIEHALL_SUCCESS, newMovieHall: data });
      break;
    default:
      yield put({ type: ADD_MOVIEHALL_FAILED });
  }
}

function* actionWatcher() {
  yield takeLatest(ADD_MOVIEHALL, addMovieHall);
}

export function* movieHallSaga() {
  yield all([actionWatcher()]);
}
