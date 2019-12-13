import {
    ADD_EMPLOYEE,
  } from '../actionTypes/Employee';
  
  export const addEmployee = (formData) => ({
    type: ADD_EMPLOYEE,
    formData,
  });
  
  