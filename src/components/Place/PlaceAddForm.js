import React from 'react';
import '../../App.css';
import { Form, Input, Select, Button, InputNumber } from 'antd';
import { useDispatch } from 'react-redux';
import { addMovieHall } from '../../state/actions/MovieHall';
const { Option } = Select;

function PlaceAddForm(props) {
  const { form } = props;
  const dispatch = useDispatch();

  const handleSubmit = (e) => {
    e.preventDefault();
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        console.log('form', values);
        dispatch(addMovieHall(values));
      }
    });
  };

  const { getFieldDecorator } = form;

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
      <Form.Item label={<span>Pavadinimas&nbsp;</span>}>
        {getFieldDecorator('name', {
          rules: [{ required: true, message: 'Prašome įrašyti pavadinimą!', whitespace: true }],
        })(<Input />)}
      </Form.Item>

      <Form.Item label="Eilių kiekis">
        {getFieldDecorator('columnCount', {
          initialValue: 10,
          rules: [{ required: true, message: 'Prašome įvesti eilių kiekį!' }],
        })(<InputNumber min={10} max={15} step="5" />)}
        <span className="ant-form-text"> Eilių kiekis</span>
      </Form.Item>

      <Form.Item label="Vietų kiekis">
        {getFieldDecorator('rowCount', {
          initialValue: 15,
          rules: [{ required: true, message: 'Prašome įvesti vietų kiekį!' }],
        })(<InputNumber min={15} max={30} step="15" />)}
        <span className="ant-form-text"> Vietų kiekis</span>
      </Form.Item>

      <Form.Item label="Kino teatras">
        {getFieldDecorator('theatre', {
          rules: [{ required: true, message: 'Pasirinkite kino teatrą!' }],
        })(
          <Select placeholder="Pasirinkite kino teatrą">
            <Option value="1">Kauno akropolis "Linkomanija"</Option>
            <Option value="2">Vilniaus Akropolis "Linkomanija"</Option>
            <Option value="3">Šiaulių Akropolis "Linkomanija"</Option>
            <Option value="4">Klaipėdos Akropolis "Linkomanija"</Option>
          </Select>,
        )}
      </Form.Item>

      <Form.Item {...tailFormItemLayout}>
        <Button type="primary" htmlType="submit">
          Pridėti
        </Button>
      </Form.Item>
    </Form>
  );
}

const placeAddForm = Form.create({ name: 'placeAdd' })(PlaceAddForm);

export default placeAddForm;
