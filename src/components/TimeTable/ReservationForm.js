import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography, Button } from 'antd';
import { useParams, useHistory } from 'react-router-dom';

const { Text } = Typography;
const ReservationForm = () => {
    let {movie, token} = useParams();
    const history = useHistory();
  return (
    <>
    {console.log(movie)}
      <Card style={{textAlign: 'center'}}>
        <Button type="primary"  onClick={() =>  history.push(`/timetable/${movie}/${token}/reserve`)}>Rezervuoti</Button>
        </Card>
        <Card style={{textAlign: 'center'}}>
      <Button type="primary"  onClick={() =>  history.push(`/timetable/${movie}/${token}/buy`)} >Pirkti</Button>
      </Card>
    </>
  );
};

export default ReservationForm;
