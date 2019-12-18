import React, { useEffect, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography } from 'antd';
import { Form, Input, Select, Button } from 'antd';
import { message } from 'antd';
import axios from 'axios';

const { Option } = Select;

const { Text } = Typography;
const ProfileEditForm = ({ form, userId }) => {
  const [user, setUser] = useState({});
  const { getFieldDecorator } = form;

  useEffect(() => {
    axios.get('/api/user/client/' + userId)
      .then((res) => {
        setUser(res.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, [])

  const handleSubmit = e => {
    e.preventDefault();
    form.validateFieldsAndScroll((error, values) => {
      if (!error) {
        delete values.prefix;
        const dto = { username: user.username, ...values };
        axios.put('/api/user/client', dto)
          .then(() => {
            message.success('Profilis pakeistas sėkmingai');
          }).catch(() => {
            message.error('Profilio pakeisti nepavyko');
          })
      }
    })
  }

  console.log(user);

  const prefixSelector = getFieldDecorator('prefix', {
    initialValue: '+370',
  })(
    <Select style={{ width: 70 }}>
      <Option value="+370">+370</Option>
      <Option value="87">+87</Option>
    </Select>,
  );


  return (
    <>
      <Card>
        <Text strong>Profilio redagavimas</Text>
        <Form onSubmit={handleSubmit}>
          <Form.Item label="Vardas">
            {getFieldDecorator('name', {
              rules: [{ required: false, message: '' }],
              initialValue: user.name,
            })(
              <Input />
            )}
          </Form.Item>
          <Form.Item label="Pavardė">
            {getFieldDecorator('surname', {
              rules: [],
              initialValue: user.surname,
            })(
              <Input />
            )}
          </Form.Item>
          <Form.Item label="Elektroninis paštas">
            {getFieldDecorator('email', {
              rules: [{
                type: 'email',
                message: 'Prašome įrašyti tinkamą elektroninį paštą!',
              }],
              initialValue: user.email,
            })(
              <Input />
            )}
          </Form.Item>
          <Form.Item label="Telefono numeris">
            {getFieldDecorator('phone_number', {
              rules: [],
              initialValue: user.phone_number,
            })(
              <Input addonBefore={prefixSelector} />
            )}
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit">
              Pateikti
            </Button>
          </Form.Item>
        </Form>
      </Card>
    </>
  );
};

export default Form.create()(ProfileEditForm);