import React, { useState, useEffect } from 'react';
import '../../App.css';
import axios from 'axios';
import {
  Form,
  Input,
  Tooltip,
  Icon,
  Select,
  Button,
  DatePicker,
  Card,
  TimePicker,
  InputNumber,
} from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { addEmployee } from '../../state/actions/Employee';
import { addClient } from '../../state/actions/client';
import { getMovieHall } from '../../state/actions/MovieHall';
import moment from 'moment';

const { Option } = Select;

function SessionAddForm(props) {
  const [confirmDirty, setConfirmDirty] = useState(false);
  const movieHalls = useSelector((store) => store.MovieHall.movieHall);
  const [movies, setMovies] = useState([]);
  const { form, userType } = props;
  const { getFieldDecorator } = form;
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getMovieHall());
    axios
      .get('/api/movie')
      .then((res) => {
        setMovies(res.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);
  if (movieHalls === undefined) {
    return null;
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        values.session_start = values.session_start.format('HH:mm');
        values.session_date = values.session_date.format('YYYY-MM-DD');
        console.log('Received values of form: ', values);
        console.log('blblbl');
        axios
          .post('/api/session', { values })
          .then((res) => {
            console.log('aa');
            console.log(res);
          })
          .catch((e) => {
            console.log(e);
          });
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
    <Card>
      <Form {...formItemLayout} onSubmit={handleSubmit}>
        <Form.Item label="Seanso pradžia">
          {getFieldDecorator('session_date', {
            rules: [{ required: true, type: 'object', message: 'Pasirinkite seanso pradžią' }],
          })(<DatePicker placeholder="Seanso pradžia" />)}
        </Form.Item>
        <Form.Item label="Seanso pradžios laikas">
          {getFieldDecorator('session_start', {
            rules: [
              { required: true, type: 'object', message: 'Pasirinkite seanso pradžios laiką' },
            ],
          })(<TimePicker placeholder="Seasnso pradžia laiką" />)}
        </Form.Item>
        <Form.Item label="Kaina">
          {getFieldDecorator('price', {
            initialValue: 3,
            rules: [{ required: true, message: 'Prašome įvesti kainą!' }],
          })(<InputNumber min={1} max={100} />)}
          <span className="ant-form-text">€</span>
        </Form.Item>
        <Form.Item label="Seanso testinumas">
          {getFieldDecorator('session_count', {
            initialValue: 1,
            rules: [{ required: true, message: 'Prašome seanso testinumą!' }],
          })(<InputNumber min={1} max={100} />)}
        </Form.Item>

        <Form.Item label="Filmas">
          {getFieldDecorator('movie_id', {
            rules: [{ required: true, message: 'Pasirinkite filmą!' }],
          })(
            <Select placeholder="Pasirinkite filmą">
              {movies.map((movie) => (
                <Option key={movie.id} value={movie.id}>
                  {movie.title}
                </Option>
              ))}
            </Select>,
          )}
        </Form.Item>
        <Form.Item label="Salė">
          {getFieldDecorator('movie_hall_id', {
            rules: [{ required: true, message: 'Pasirinkite kino salė!' }],
          })(
            <Select placeholder="Pasirinkite kino salę">
              {movieHalls.map((movieHall) => (
                <Option
                  key={movieHall.id}
                  value={movieHall.id}
                >{`${movieHall.movieTheatre.name} ${movieHall.name}`}</Option>
              ))}
            </Select>,
          )}
        </Form.Item>

        <Form.Item {...tailFormItemLayout}>
          <Button type="primary" htmlType="submit">
            Pridėti
          </Button>
        </Form.Item>
      </Form>
    </Card>
  );
}

const sesionAdd = Form.create({ name: 'sessionAdd' })(SessionAddForm);

export default sesionAdd;
