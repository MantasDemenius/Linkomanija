import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography, Table, Divider, Tag, Button } from 'antd';

const { Title } = Typography;

const dataSource = [
    {
        key: '1',
        time: '20:00',
        title: 'Džokeris',
    },
    {
        key: '1',
        time: '22:40',
        title: 'Džokeris',
    },
];

const columns = [
    {
        title: 'Time',
        dataIndex: 'time',
        key: 'time',
        width: 150,
        render: text => <Title level={2}>{text}</Title>,
    },
    {
        title: 'Title',
        dataIndex: 'title',
        key: 'title',
        render: text => <Title level={4}>{text}</Title>,
    },
    {
        title: 'Action',
        key: 'action',
        align: 'right',
        render: () => (
            <Button type="primary" size="large" block>Bilietai</Button>
        ),
    },
];

const TimeTablePage = () => {
    return (
        <Card>
            <Divider style={{ marginBottom: 0 }} />
            <Table dataSource={dataSource} columns={columns} showHeader={false} />
        </Card>
    )
}

export default TimeTablePage;