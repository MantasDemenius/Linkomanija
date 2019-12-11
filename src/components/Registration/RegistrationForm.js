import React from 'react';
import '../../App.css';
import { Form, Input, Tooltip, Icon, Select, Button, DatePicker } from 'antd';

const { Option } = Select;

class RegistrationForm extends React.Component {
  state = {
    confirmDirty: false,
    autoCompleteResult: [],
  };

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
      }
      console.log(values.bornDate.format('YYYY-MM-DD'));
    });
  };

  handleConfirmBlur = (e) => {
    const { value } = e.target;
    this.setState({ confirmDirty: this.state.confirmDirty || !!value });
  };

  render() {
    const { getFieldDecorator } = this.props.form;

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
    const prefixSelector = getFieldDecorator('prefix', {
      initialValue: '+370',
    })(
      <Select style={{ width: 70 }}>
        <Option value="+370">+370</Option>
        <Option value="87">+87</Option>
      </Select>,
    );

    return (
      <Form {...formItemLayout} onSubmit={this.handleSubmit}>
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
          {getFieldDecorator('nickname', {
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

        <Form.Item label="Teatras">
          {getFieldDecorator('theatre', {
            rules: [{ required: true, message: 'Pasirinkite teatrą!' }],
          })(
            <Select placeholder="Pasirinkite teatrą">
              <Option value="1">zirmunai</Option>
              <Option value="87">+87</Option>
            </Select>,
          )}
        </Form.Item>

        <Form.Item label="Telefono numeris">
          {getFieldDecorator('phone', {
            rules: [{ message: 'Please input your phone number!' }],
          })(<Input addonBefore={prefixSelector} style={{ width: '100%' }} />)}
        </Form.Item>

        <Form.Item label="Gimimo data">
          {getFieldDecorator('bornDate', {
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
}

export default RegistrationForm;
