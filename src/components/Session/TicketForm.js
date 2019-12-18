import React, { useState, useEffect } from 'react';
import '../../App.css';
import { Form, Select, Button, Card, message } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import smallerPicture from '../../pictures/10_15.png';
import biggerPicture from '../../pictures/15_30.png';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const { Option } = Select;

function TicketForm(props) {
  const [session, setSession] = useState([]);
  const [seats, setSeats] = useState([]);
  const [activeRows, setActiveRows] = useState([]);
  const [activeSeats, setActiveSeats] = useState([]);
  let { key } = useParams();
  const { form, formType } = props;
  const { getFieldDecorator } = form;
  const user = useSelector((store) => store.client.userId);
  useEffect(() => {
    axios
      .get(`/api/session/${key}`)
      .then((res) => {
        console.log("ses",res.data);
        setSession(res.data);
        
      })
      .catch((e) => {
        console.log(e);
      });
    axios
      .get(`/api/session/seats/${key}`)
      .then((res) => {
        console.log(res);
        setSeats(res.data);
        let array = Array.from(Array(res.data[0].length), (x, index) => index +1);
        setActiveRows(array);
        console.log(array);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    form.validateFieldsAndScroll((err, values) => {
      values.user_client_id = user;
      values.session_id = parseInt(key, 10);
      if (formType === 'reserve') {
        values.ticket_state = false;
      } else if (formType === 'buy') {
        values.ticket_state = true;
      }
      values.creation_date = '1';
      if (!err) {
        axios
          .post('/api/reservation', values)
          .then(function(response) {
            console.log(response);

            message.success('Sėkmingai įsigijote vietas');
            // history.push('/movies');
          })
          .catch(function(error) {
            console.log(error);
            message.error('Nepavyko įsigyti vietų');
          });

        console.log('Received values of form: ', values);
      }
    });
  };

  const handleChange = (value) => {
    setActiveSeats(seats[value]);
  }

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

  if (session.movieHall === undefined) {
    return null;
  }
  return (
    <Card>
      <Form {...formItemLayout} onSubmit={handleSubmit}>
        {session.movieHall.column_count < 11 ? (
          <img src={smallerPicture} width="80%" height="80%" alt="sale su 10 eiliu ir 15 vietu" />
        ) : (
          <img src={biggerPicture} width="80%" height="80%" alt="sale su 15 eiliu ir 30 vietu" />
        )}

        <Form.Item label="Eilė">
          {getFieldDecorator('seat_row', {
            rules: [{ required: true, message: 'Pasirinkitę eilę' }],
          })(
            <Select onChange={handleChange}>
              {activeRows.map((seat) => (
                <Option key={seat} value={seat}>
                  {seat}
                </Option>
              ))}
            </Select>,
          )}
        </Form.Item>
        <Form.Item label="Vieta">
          {getFieldDecorator('seat_column', {
            rules: [{ required: true, message: 'Pasirinkitę vietą' }],
          })(
            <Select>
              {activeSeats.map((seat) => (
                <Option key={seat.id} value={seat.seat}>
                  {seat.seat}
                </Option>
              ))}
            </Select>,
          )}
        </Form.Item>

        <Form.Item {...tailFormItemLayout}>
          <Button type="primary" htmlType="submit">
            {formType === 'reserve' ? 'Rezervuoti' : 'Pirkti'}
          </Button>
        </Form.Item>
      </Form>
    </Card>
  );
}

export default TicketForm;
