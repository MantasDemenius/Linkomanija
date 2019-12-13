import {
    ADD_CLIENT,
  } from '../actionTypes/client';
  
  export const addClient = (formData) => ({
    type: ADD_CLIENT,
    formData,
  });
  
  