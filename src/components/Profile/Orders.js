import React, { useEffect, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { List, Typography } from 'antd';
import axios from 'axios';

const Orders = ({ userId }) => {
    const [orders, setOrders] = useState([]);

    const data = [];

    useEffect(() => {
        axios.get('/api/reservation/client/' + userId)
            .then((res) => {
                setOrders(res.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }, [])
    console.log(orders)

    return (
        <>
            <Card>
                <h3>Užsakymai</h3>
                <List
                    size="large"
                    bordered
                    dataSource={orders}
                    renderItem={item => <List.Item><b>{`${item.ticket_state ? 'Bilietas' : 'Rezervacija'}`}</b> {`${item.session.movie.title} - ${item.session.movieHall.movieTheatre.name},
                        ${item.session.movieHall.name}, Eilė ${item.seat_row}, Vieta ${item.seat_collumn}`}</List.Item>}
                />
            </Card>
        </>
    );
};

export default Orders;
