import React, { useEffect, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { List } from 'antd';
import axios from 'axios';
import { format } from 'date-fns';

const Timetable = ({ userId }) => {
    const [timetable, setTimetable] = useState([]);

    const data = [];

    useEffect(() => {
        axios.get('/api/timetable/' + userId)
            .then((res) => {
                setTimetable(res.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }, [])

    timetable.forEach(item => {
        item.timetable_start = format(Date.parse(item.timetable_start), 'yyyy-MM-dd hh:mm');
        item.timetable_end = format(Date.parse(item.timetable_end), 'yyyy-MM-dd hh:mm');
        data.push(item);
    });

    return (
        <>
            <Card>
                <h3>Darbo grafikas</h3>
                <List
                    size="large"
                    bordered
                    dataSource={data}
                    renderItem={item => <List.Item>{"Nuo " + item.timetable_start + " iki " + item.timetable_end + " | " + item.comment}</List.Item>}
                />
            </Card>
        </>
    );
};

export default Timetable;
