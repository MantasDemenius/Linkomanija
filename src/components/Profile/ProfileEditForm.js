import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const ProfileEditForm = () => {
  return (
    <>
      <Card>
        <Text strong>Čia bus profilio redagavimo forma</Text>
      </Card>
    </>
  );
};

export default ProfileEditForm;
