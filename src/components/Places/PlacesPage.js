import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography, Button } from 'antd';
import { useHistory } from 'react-router-dom';

const { Text } = Typography;
const PlacesPage = () => {
  let history = useHistory();
  return (
    <>
      <Card>
        <Text strong>Patalpų foto galerija</Text>
      </Card>
      <Card>
        <Text strong>Žemėlaptio langas</Text>
      </Card>
      <Card>
        <Button onClick={() => history.push('/places/add')}>Pridėti</Button>
        <Button onClick={() => history.push('/places/delete')}>Ištrinti</Button>
        <Button onClick={() => history.push('/places/edit')}>Redaguoti</Button>
      </Card>
    </>
  );
};

export default PlacesPage;
