import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const uzsakymuistorija = () => {
  return (
    <>
      <Card>
        <Text strong>Čia bus uzsakymo istorija</Text>
      </Card>
    </>
  );
};

export default uzsakymuistorija;
