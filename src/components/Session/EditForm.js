import React, { useState, useEffect } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import moment from 'moment';
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
  InputNumber,message
} from 'antd';
import { Typography } from 'antd';
import { useParams } from 'react-router-dom';
import  axios  from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { getMovieHall } from '../../state/actions/MovieHall';

const { Option } = Select;
const { Text } = Typography;
const EditForm = (props) => {
  const [session, setSession] = useState([]);
  const movieHalls = useSelector((store) => store.MovieHall.movieHall);
  const [movies, setMovies] = useState([]);
  let { id } = useParams();
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
    axios
      .get(`/api/session/${id}`)
      .then((res) => {
        console.log(res);
        setSession(res.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        values.session_start = values.session_start.format('HH:mm');
        values.session_date = values.session_date.format('YYYY-MM-DD');
        values.id = parseInt(id, 10);
        console.log('Received values of form: ', values);

        axios
          .post('/api/session/edit', values)
          .then(function(response) {
            console.log(response);
            
            message.success('Filmo seansas sėkmingai pakeistas')
            // history.push('/movies');
          })
          .catch(function(error) {
            console.log(error);
            message.error('Filmo seansas nebuvo pakeistas')
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

  if (movieHalls === undefined || session.movie === undefined || movies === undefined) {
    return null;
  }

  return (
    <>
      <Card>
      <Form {...formItemLayout} onSubmit={handleSubmit}>
        <Form.Item label="Seanso pradžia">
          {getFieldDecorator('session_date', {
            initialValue: moment(session.session_date, 'YYYY-MM-DD'),
            rules: [{ required: true, type: 'object', message: 'Pasirinkite seanso pradžią' }],
          })(<DatePicker />)}
        </Form.Item>
        <Form.Item label="Seanso pradžios laikas">
          {getFieldDecorator('session_start', {
            initialValue: moment(session.session_start, 'HH:mm:ss'),
            rules: [
              { required: true, type: 'object', message: 'Pasirinkite seanso pradžios laiką' },
            ],
          })(<TimePicker/>)}
        </Form.Item>
        <Form.Item label="Kaina">
          {getFieldDecorator('price', {
            initialValue: session.price,
            rules: [{ required: true, message: 'Prašome įvesti kainą!' }],
          })(<InputNumber min={1} max={100} />)}
          <span className="ant-form-text">€</span>
        </Form.Item>
          {console.log("movie",session.movie)}
        <Form.Item label="Filmas">
          {getFieldDecorator('movie_id', {
            initialValue: session.movie.id,
            rules: [{ required: true, message: 'Pasirinkite filmą!' }],
          })(
            <Select>
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
            initialValue: session.movieHall.id,
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
    </>
  );
};

const sessionEdit = Form.create({ name: 'sessionEdit' })(EditForm);

export default sessionEdit;
