import React, { useEffect } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography } from 'antd';
import { Form, Input, Tooltip, Icon, Select, Button, DatePicker } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import {userLogin, removeCreateStatus} from '../../state/actions/client'
import { useHistory } from 'react-router-dom';

const { Text } = Typography;

const LoginPage = (props) => {
  const { form } = props;
  const { getFieldDecorator } = form;
  const dispatch = useDispatch();
  let history = useHistory();

  const createStatus = useSelector((store) => store.client.createStatus);

  function getSubmitMessage() {
    if (createStatus === false) {
      return <h1>failed</h1>
      // return <FormError Tag="h2" message={'Cannot create session'} />;
    }
    if (createStatus === true) {
        
        history.push('/');
      // return <FormError Tag="h2" message={'Session created'} color="green" />;
    }
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        console.log(values);
        dispatch(userLogin(values));
      }
      
    });
  };


  return (
    <Card>
      <Text strong>Čia bus prisijungimo forma</Text>
      {getSubmitMessage()}
      <Form onSubmit={handleSubmit}>
      <Form.Item label={<span>Slapyvardis&nbsp;</span>}>
        {getFieldDecorator('username', {
          rules: [{ required: true, message: 'Prašome įrašyti slapyvardį!', whitespace: true }],
        })(<Input />)}
      </Form.Item>
      <Form.Item label="Slaptažodis" hasFeedback>
        {getFieldDecorator('password', {
          rules: [
            {
              required: true,
              message: 'Prašome įvesti slaptažodį!',
            },
          ],
        })(<Input.Password />)}
      </Form.Item>
      <Button type="primary" htmlType="submit">
          Prisijungti
        </Button>
        </Form>
    </Card>
  );
};

const loginForm = Form.create({ name: 'login' })(LoginPage);

export default loginForm;
