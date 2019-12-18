import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Form, Card, message } from 'antd';

import RegistrationForm from '../Registration/RegistrationForm';
import { useDispatch, useSelector } from 'react-redux';
import { Typography } from 'antd';

const WrappedRegistrationForm = Form.create({ name: 'register' })(RegistrationForm);
const SignupPage = () => {
  const createStatus = useSelector((store) => store.client.createStatus);
  function getSubmitMessage() {
    if (createStatus === false) {
      message.error("Nepavyko užsiregistruoti")
      // return <FormError Tag="h2" message={'Cannot create session'} />;
    }
    if (createStatus === true) {
      message.success("Registracija sėkminga");
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
