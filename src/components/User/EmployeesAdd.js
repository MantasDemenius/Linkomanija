import React from 'react';
import '../../App.css';
import { Form, Card, message } from 'antd';
import RegistrationForm from '../Registration/RegistrationForm';
import { useDispatch, useSelector } from 'react-redux';

const WrappedRegistrationForm = Form.create({ name: 'register' })(RegistrationForm);

const EmployeesAdd = () => {
  const createStatus = useSelector((store) => store.Employee.createStatus);

  function getSubmitMessage() {
    if (createStatus === false) {
      message.error("Nepavyko sukurti darbuotojo");
      // return <FormError Tag="h2" message={'Cannot create session'} />;
    }
    if (createStatus === true) {
      message.success("Darbuotojas sukurtas");
      // return <FormError Tag="h2" message={'Session created'} color="green" />;
    }
  }

  return (
    <Card title="Darbuotojo registracija">
      {getSubmitMessage()}
      <WrappedRegistrationForm userType="employee" />
    </Card>
  );
};

export default EmployeesAdd;
