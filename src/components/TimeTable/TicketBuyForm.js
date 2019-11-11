import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const TicketBuyForm = () => {
  return (
    <>
      <Card>
        <Text strong>Čia bus bilieto pirkimo forma</Text>
      </Card>
    </>
  );
};

export default TicketBuyForm;
