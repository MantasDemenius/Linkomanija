import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography, Button } from 'antd';
import { useParams, useHistory } from 'react-router-dom';



const { Text } = Typography;
const ReservationForm = () => {
    let {key} = useParams();
    const history = useHistory();
  return (
    <>
      <Card style={{textAlign: 'center'}}>
        <Button type="primary"  onClick={() =>  history.push(`/seansas/${key}/rezervuoti`)}>Rezervuoti</Button>
        </Card>
        <Card style={{textAlign: 'center'}}>
      {/* <Button type="primary"  onClick={() =>  history.push(`/timetable/${movie}/${token}/buy`)} >Pirkti</Button> */}
      </Card>
    </>
  );
};

export default ReservationForm;
