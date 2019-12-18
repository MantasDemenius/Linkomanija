import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography, Button, Carousel } from 'antd';
import { useHistory } from 'react-router-dom';
import { useSelector } from 'react-redux';

const { Text } = Typography;
const PlacesPage = () => {
  let history = useHistory();
  const user = useSelector((store) => store.client.userType);
  return (
    <>
      <Card>
        <Text strong>Patalpų foto galerija</Text>
        <div>
            <img
              src="https://www.akropolis.eu/assets/bulkUpload/_resampled/CroppedImage600500-Akropolis-fasade2.jpg"
              alt="Kauno akropolis"
              height="300" width="300"
            ></img>
            <img
              src="https://s2.15min.lt/static/cache/OTI1eDYxMCwxMjIweDU4NSw2MTYyMDksb3JpZ2luYWwsLGlkPTQ0MTUzNDYmZGF0ZT0yMDE5JTJGMDElMkYwNiwyNTMzOTMyNjY4/ispardavimas-prekybos-centre-5c31d83d7cfb6.jpg"
              alt="Vilniaus akropolis"
              height="300" width="300"
            ></img>
            <img
              src="https://www.akropolis.lt/image/155427869671_400_400_1.jpg"
              alt="Šiaulių akropolis"
              height="300" width="300"
            ></img>
            <img
              src="https://www.akropolis.eu/assets/bulkUpload/_resampled/CroppedImage400300-KB8-8343-1.jpg"
              alt="Klaipėdos akropolis"
              height="300" width="300"
            ></img>
        </div>
        
      </Card>
      <Card>
        <Text strong>Žemėlaptio langas</Text>
      </Card>
      {user === 'admin' && (
        <Card>
          Patalpų panelė
          <Button onClick={() => history.push('/patalpa/prideti')}>Pridėti</Button>
          <Button onClick={() => history.push('/patalpa/panaikinimas')}>Ištrinti</Button>
          <Button onClick={() => history.push('/places/edit')}>Redaguoti</Button>
        </Card>
      )}
    </>
  );
};

export default PlacesPage;
