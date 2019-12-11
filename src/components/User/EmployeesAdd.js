import React from 'react';
import '../../App.css';
import { Form, Card } from 'antd';
import RegistrationForm from '../Registration/RegistrationForm';

const WrappedRegistrationForm = Form.create({ name: 'register' })(RegistrationForm);

const EmployeesAdd = () => {
  return (
    <Card title="Darbuotojo registracija">
      <WrappedRegistrationForm userType="employee" />
    </Card>
  );
};

export default EmployeesAdd;
