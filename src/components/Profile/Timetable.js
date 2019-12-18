import React, { useEffect, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { List, Typography } from 'antd';
import axios from 'axios';

const Orders = ({ userId }) => {
    const [timetable, setTimetable] = useState([]);

    const data = [
        'Racing car sprays burning fuel into crowd.',
        'Japanese princess to wed commoner.',
        'Australian walks 100km after outback crash.',
        'Man charged over missing wedding girl.',
        'Los Angeles battles huge wildfires.',
    ];

    useEffect(() => {
        axios.get('/api/timetable/' + userId)
            .then((res) => {
                setTimetable(res.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }, [])

    return (
        <>
            <Card>
                <h3>Darbo grafikas</h3>
                <List
                    size="large"
                    bordered
                    dataSource={data}
                    renderItem={item => <List.Item>{item}</List.Item>}
                />
            </Card>
        </>
    );
};

export default Orders;
