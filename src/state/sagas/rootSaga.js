import { all, fork } from 'redux-saga/effects';

import { movieHallSaga } from './movieHallSaga';
import { employeeSaga } from './employeeSaga';
import { clientSaga } from './clientSaga';

export default function* rootSaga() {
  yield all([fork(movieHallSaga), fork(employeeSaga), fork(clientSaga)]);
}
