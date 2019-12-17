import {
    ADD_CLIENT,
    USER_LOGIN,
    CREATE_STATUS_REMOVE
  } from '../actionTypes/client';
  
  export const addClient = (formData) => ({
    type: ADD_CLIENT,
    formData,
  });
  export const userLogin = (formData) => ({
    type: USER_LOGIN,
    formData,
  });
  export const removeCreateStatus = () => ({
    type: CREATE_STATUS_REMOVE,
  });
  
  