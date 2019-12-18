import React, { useState } from 'react';
import '../../App.css';
import { Form, Input, Tooltip, Icon, Select, Button, DatePicker } from 'antd';
import { useDispatch } from 'react-redux';
import { addEmployee } from '../../state/actions/Employee';
import { addClient } from '../../state/actions/client';

const { Option } = Select;

function TicketForm(props) {
  const [confirmDirty, setConfirmDirty] = useState(false);

  const { form, userType } = props;
  const { getFieldDecorator } = form;
  const dispatch = useDispatch();

  const handleSubmit = (e) => {
    e.preventDefault();
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        if (values.bornDate) {
          values.bornDate = values.bornDate.format('YYYY-MM-DD');
        }
        console.log('Received values of form: ', values);
        if(userType === 'employee'){
          values.theatre_id = parseInt(values.theatre_id, 10);
          values.phone_number = `${values.prefix}${values.phone_number}`;
        dispatch(addEmployee(values));
        }else if(userType === 'client'){
          dispatch(addClient(values));
        }
      }
    });
  };

  const formItemLayout = {
    labelCol: {
      xs: { span: 24 },
      sm: { span: 8 },
    },
    wrapperCol: {
      xs: { span: 24 },
      sm: { span: 16 },
    },
  };
  const tailFormItemLayout = {
    wrapperCol: {
      xs: {
        span: 24,
        offset: 0,
      },
      sm: {
        span: 16,
        offset: 8,
      },
    },
  };

  return (
    <Form {...formItemLayout} onSubmit={handleSubmit}>
      <Form.Item label={<span>Vardas&nbsp;</span>}>
        {getFieldDecorator('name', {
          rules: [{ required: true, message: 'Prašome įrašyti vardą!', whitespace: true }],
        })(<Input />)}
      </Form.Item>

      <Form.Item label={<span>Pavardė</span>}>
        {getFieldDecorator('surname', {
          rules: [{ required: true, message: 'Prašome įrašyti pavardę!', whitespace: true }],
        })(<Input />)}
      </Form.Item>

      <Form.Item
        label={
          <span>
            Slapyvardis&nbsp;
            <Tooltip title="Prisijungimo vardas">
              <Icon type="question-circle-o" />
            </Tooltip>
          </span>
        }
      >
        {getFieldDecorator('username', {
          rules: [{ required: true, message: 'Prašome įrašyti slapyvardį!', whitespace: true }],
        })(<Input />)}
      </Form.Item>

      <Form.Item label="Elektroninis paštas">
        {getFieldDecorator('email', {
          rules: [
            {
              type: 'email',
              message: 'Prašome įrašyti tinkamą elektroninį paštą!',
            },
            {
              required: true,
              message: 'Prašome įrašyti elektroninį paštą!',
            },
          ],
        })(<Input />)}
      </Form.Item>

      {userType === 'employee' && (
        <Form.Item label="Teatras">
          {getFieldDecorator('theater_id', {
            rules: [{ required: true, message: 'Pasirinkite teatrą!' }],
          })(
            <Select placeholder="Pasirinkite kino teatrą">
            <Option value="1">Kauno akropolis "Linkomanija"</Option>
            <Option value="2">Vilniaus Akropolis "Linkomanija"</Option>
            <Option value="3">Šiaulių Akropolis "Linkomanija"</Option>
            <Option value="4">Klaipėdos Akropolis "Linkomanija"</Option>
          </Select>,
          )}
        </Form.Item>
      )}

      <Form.Item label="Telefono numeris">
        {getFieldDecorator('phone_number', {
          rules: [{ message: 'Please input your phone number!' }],
        })(<Input style={{ width: '100%' }} />)}
      </Form.Item>

      <Form.Item label="Gimimo data">
        {getFieldDecorator('born_date', {
          rules: [{ type: 'object', message: 'Please select time!' }],
        })(<DatePicker placeholder="Gimimo data" />)}
      </Form.Item>

      <Form.Item {...tailFormItemLayout}>
        <Button type="primary" htmlType="submit">
          Registruoti
        </Button>
      </Form.Item>
    </Form>
  );
}

export default TicketForm;
