import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography, Table, Divider, Tag, Button } from 'antd';
import { Select } from 'antd';
import { format, addDays, startOfToday, formatRelative } from 'date-fns';
import { lt } from 'date-fns/locale'

const { Option } = Select;
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

    const options = [];
    const today = startOfToday();
    for (let i = 0; i < 7; i++) {
        const date = addDays(today, i);
        let formattedDate = format(date, 'MMMM dd', { locale: lt });
        if (i === 0)
            formattedDate = "Šiandien";
        if (i === 1)
            formattedDate = "Rytoj";
        options.push(<Option key={i}>{formattedDate.charAt(0).toUpperCase() + formattedDate.slice(1)}</Option>);
    }

    function handleChange(value) {
        console.log(`selected ${value}`);
    }

    return (
        <Card>
            <Select defaultValue="0" style={{ width: 200 }} onChange={handleChange}>
                {options}
            </Select>
            <Divider style={{ marginBottom: 0 }} />
            <Table dataSource={dataSource} columns={columns} showHeader={false} />
        </Card>
    )
}

export default TimeTablePage;