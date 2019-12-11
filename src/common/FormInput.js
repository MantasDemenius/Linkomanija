import React from 'react';
import {Input } from 'antd';

const FormInput = (name, placeholder, value, handleChange) => {
  <Input
    required
    fullWidth
    name={name}
    variant="outlined"
    placeholder={placeholder}
    type="password"
    style={{ marginTop: '20px' }}
    value={value}
    onChange={handleChange}
  />;
};

export default FormInput;
