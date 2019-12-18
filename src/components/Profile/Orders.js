import React, { useEffect, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { List, Typography } from 'antd';
import axios from 'axios';

const Orders = ({ userId }) => {
    const [orders, setOrders] = useState([]);

    const data = [
        'Racing car sprays burning fuel into crowd.',
        'Japanese princess to wed commoner.',
        'Australian walks 100km after outback crash.',
        'Man charged over missing wedding girl.',
        'Los Angeles battles huge wildfires.',
    ];

    useEffect(() => {
        axios.get('/api/user/client/' + userId)
            .then((res) => {
                setOrders(res.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }, [])

    return (
        <>
            <Card>
                <h3>Užsakymai</h3>
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
