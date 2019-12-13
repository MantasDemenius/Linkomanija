import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Form, Card } from 'antd';

import RegistrationForm from '../Registration/RegistrationForm';
import { useDispatch, useSelector } from 'react-redux';
import { Typography } from 'antd';

const WrappedRegistrationForm = Form.create({ name: 'register' })(RegistrationForm);
const SignupPage = () => {
  const createStatus = useSelector((store) => store.client.createStatus);
  function getSubmitMessage() {
    if (createStatus === false) {
      return <h1>failed</h1>
      // return <FormError Tag="h2" message={'Cannot create session'} />;
    }
    if (createStatus === true) {
      return <h1>success</h1>
      // return <FormError Tag="h2" message={'Session created'} color="green" />;
    }
  }
  return (
    <Card title="Registracija">
      {getSubmitMessage()}
      <WrappedRegistrationForm userType="client" />
    </Card>
  );
};

export default SignupPage;
