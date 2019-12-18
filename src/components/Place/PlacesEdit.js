import React, { useEffect, useState } from 'react';
import '../../App.css';
import { Form, Input, Select, Button, InputNumber, Card, Typography } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { addMovieHall, getMovieHall } from '../../state/actions/MovieHall';
import axios from 'axios';
const { Option } = Select;
const { Title } = Typography;
function PlacesEdit(props) {
  const { form } = props;
  const dispatch = useDispatch();
  const movieHall = useSelector((store) => store.MovieHall.movieHall);
  const [selectedMovieHall, setSelectedMovieHall] = useState(undefined);


  useEffect(() => {
    dispatch(getMovieHall());
  }, [])

  const handleSubmit = (e) => {
    e.preventDefault();
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        console.log('form', values);
        axios
      .post(`/api/movieHall/edit`, values)
      .then((res) => {
        console.log(res);
        // setSession(res.data);
      })
      .catch((e) => {
        console.log(e);
      });
      }
    });
  };

  const handleChange =(value) =>{
    setSelectedMovieHall(movieHall[value]);
  }

  const { getFieldDecorator } = form;

  const formItemLayout = {
    labelCol: {
      xs: { span: 24 },
      sm: { span: 4 },
    },
    wrapperCol: {
      xs: { span: 24 },
      sm: { span: 8 },
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
      <Card>
          <Title level={2}>Pasirinkitę salę kurią norite redaguoti</Title>
      <Select style={{ width: '50%' }} onChange={handleChange}>
          {movieHall !== undefined && movieHall.map((hall) => 
              <Option key={hall.id} value={hall.id}>{`${hall.movieTheatre.name} ${hall.name}`}</Option>
          )}
      </Select>
      <br/>
      <br/>
      {selectedMovieHall !== undefined &&
      
    <Form {...formItemLayout} onSubmit={handleSubmit}>
      <Form.Item label={<span>Pavadinimas&nbsp;</span>}>
        {getFieldDecorator('name', {
            initialValue: selectedMovieHall.name,
          rules: [{ required: true, message: 'Prašome įrašyti pavadinimą!', whitespace: true }],
        })(<Input />)}
      </Form.Item>

      <Form.Item label="Eilių kiekis">
        {getFieldDecorator('columnCount', {
          initialValue: selectedMovieHall.column_count,
          rules: [{ required: true, message: 'Prašome įvesti eilių kiekį!' }],
        })(<InputNumber min={10} max={15} step="5" />)}
        <span className="ant-form-text"> Eilių kiekis</span>
      </Form.Item>

      <Form.Item label="Vietų kiekis">
        {getFieldDecorator('rowCount', {
          initialValue: selectedMovieHall.row_count,
          rules: [{ required: true, message: 'Prašome įvesti vietų kiekį!' }],
        })(<InputNumber min={15} max={30} step="15" />)}
        <span className="ant-form-text"> Vietų kiekis</span>
      </Form.Item>

      <Form.Item label="Kino teatras">
        {getFieldDecorator('theatre', {
            initialValue: selectedMovieHall.movieTheatre.id,
          rules: [{ required: true, message: 'Pasirinkite kino teatrą!' }],
        })(
          <Select>
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
    </Form>}
    </Card>
  );
}

const placeEdit = Form.create({ name: 'placeEdit' })(PlacesEdit);

export default placeEdit;
