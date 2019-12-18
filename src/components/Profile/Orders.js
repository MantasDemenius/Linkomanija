import React from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;
const Orders = () => {
    return (
        <>
            <Card>
                <Text strong>Užsakymai</Text>
            </Card>
        </>
    );
};

export default Orders;
