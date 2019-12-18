import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card, Form } from 'antd';
import { Typography } from 'antd';
import TicketForm from './TicketForm';

const WrappedTicketForm = Form.create({ name: 'ticketForm' })(TicketForm);

const { Text } = Typography;
const TicketReserveForm = () => {
  return (
    <>
      <Card>
      <Text strong>Rezervuoti vietą</Text>
        <WrappedTicketForm formType='reserve'/>
       
      </Card>
    </>
  );
};

export default TicketReserveForm;
