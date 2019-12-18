import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography, Form } from 'antd';
import TicketForm from './TicketForm';

const WrappedTicketForm = Form.create({ name: 'ticketForm' })(TicketForm);

const { Text } = Typography;
const TicketBuyForm = () => {
  return (
    <>
      <Card>
        <Text strong>Pirkti bilietą</Text>
        <WrappedTicketForm formType='buy'/>
      </Card>
    </>
  );
};

export default TicketBuyForm;
