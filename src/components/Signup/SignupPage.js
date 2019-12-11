import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Form, Card } from 'antd';

import RegistrationForm from '../Registration/RegistrationForm';
import { Typography } from 'antd';

const WrappedRegistrationForm = Form.create({ name: 'register' })(RegistrationForm);
const SignupPage = () => {
  return (
    <Card title="Registracija">
      <WrappedRegistrationForm userType="client" />
    </Card>
  );
};

export default SignupPage;
