import React, {useState} from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography, message } from 'antd';
import { useDispatch, useSelector } from 'react-redux';

import PlaceAddForm from './PlaceAddForm';

const { Text } = Typography;
const PlaceAdd = () => {
    const createStatus = useSelector((store) => store.MovieHall.createStatus);

    function getSubmitMessage() {
      if (createStatus === false) {
        message.error("Nepavyko pridėti salės");
        // return <FormError Tag="h2" message={'Cannot create session'} />;
      }
      if (createStatus === true) {
        message.success("Sėkmingai pridėta salė");
        // return <FormError Tag="h2" message={'Session created'} color="green" />;
      }
    }

    return (
        <Card >
            {getSubmitMessage()}
            <Text strong>Pridėti vietą</Text>
            <PlaceAddForm/>
        </Card>
    )
}

export default PlaceAdd;