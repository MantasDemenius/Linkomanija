import {
    ADD_CLIENT,
    USER_LOGIN
  } from '../actionTypes/client';
  
  export const addClient = (formData) => ({
    type: ADD_CLIENT,
    formData,
  });
  export const userLogin = (formData) => ({
    type: USER_LOGIN,
    formData,
  });
  
  