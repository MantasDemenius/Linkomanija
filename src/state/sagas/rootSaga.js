import { all, fork } from 'redux-saga/effects';

import { movieHallSaga } from './movieHallSaga';
import { employeeSaga } from './employeeSaga';

export default function* rootSaga() {
  yield all([fork(movieHallSaga), fork(employeeSaga)]);
}
