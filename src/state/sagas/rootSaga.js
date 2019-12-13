import { all, fork } from 'redux-saga/effects';

import { movieHallSaga } from './movieHallSaga';

export default function* rootSaga() {
  yield all([fork(movieHallSaga)]);
}
