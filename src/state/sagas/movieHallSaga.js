import { put, all, takeLatest } from 'redux-saga/effects';

import {
  ADD_MOVIEHALL,
  ADD_MOVIEHALL_SUCCESS,
  ADD_MOVIEHALL_FAILED,
  GET_MOVIEHALL,
  GET_MOVIEHALL_FAILED,
  GET_MOVIEHALL_SUCCESS,
  DELETE_MOVIEHALL,
  DELETE_MOVIEHALL_FAILED,
  DELETE_MOVIEHALL_SUCCESS
} from '../actionTypes/MovieHall';

import { RESPONSE_STATUS, getRequest, postRequest, deleteRequest } from '../../common/ApiRequests';
import {ADD_MOVIEHALL_ROUTE} from '../../common/Routes';

function* addMovieHall(action) {
  console.log("saga", action.formData);
  const { status, data } = yield postRequest(ADD_MOVIEHALL_ROUTE, action.formData);
  console.log(data);
  switch (status) {
    case RESPONSE_STATUS.OK:
      yield put({ type: ADD_MOVIEHALL_SUCCESS });
      break;
    default:
      yield put({ type: ADD_MOVIEHALL_FAILED });
  }
}


function* getMovieHall() {
  const { status, data } =  yield getRequest(`/movieHall`);

  switch (status) {
    case RESPONSE_STATUS.OK:
      yield put({ type: GET_MOVIEHALL_SUCCESS, movieHalls: data });
      break;
    case RESPONSE_STATUS.BAD_RESPONSE:
      yield put({ type: GET_MOVIEHALL_FAILED, error: 'There are no sessions for this name' });
      break;
    default:
      yield put({ type: GET_MOVIEHALL_FAILED, error: 'Could not connect to server' });
  }
}

function* deleteMovieHall(action) {
  const { status, data } =  yield deleteRequest(`/movieHall/${action.id}`);

  switch (status) {
    case RESPONSE_STATUS.OK:
      yield put({ type: DELETE_MOVIEHALL_SUCCESS, hallId: action.id });
      break;
    case RESPONSE_STATUS.BAD_RESPONSE:
      yield put({ type: DELETE_MOVIEHALL_FAILED, error: 'There are no sessions for this name' });
      break;
    default:
      yield put({ type: DELETE_MOVIEHALL_FAILED, error: 'Could not connect to server' });
  }
}


function* actionWatcher() {
  yield takeLatest(ADD_MOVIEHALL, addMovieHall);
  yield takeLatest(GET_MOVIEHALL, getMovieHall);
  yield takeLatest(DELETE_MOVIEHALL, deleteMovieHall);
}

export function* movieHallSaga() {
  yield all([actionWatcher()]);
}
