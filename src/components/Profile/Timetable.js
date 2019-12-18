import React, { useEffect, useCallback, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card, message } from 'antd';
import { List } from 'antd';
import axios from 'axios';
import { format } from 'date-fns';
import TimetableForm from './TimetableForm';
import { useParams } from 'react-router-dom';

const Timetable = ({ userId, isAdminMode }) => {
    const [timetable, setTimetable] = useState([]);
    const [state, updateState] = React.useState();
    const forceUpdate = useCallback(() => updateState({}), []);
    let { id } = useParams();
    const data = [];

    if (!userId)
        userId = id;

    useEffect(() => {
        axios.get('/api/timetable/' + userId)
            .then((res) => {
                setTimetable(res.data);
                forceUpdate();
            })
    }, [state])

    timetable.forEach(item => {
        item.timetable_start = format(Date.parse(item.timetable_start), 'yyyy-MM-dd hh:mm');
        item.timetable_end = format(Date.parse(item.timetable_end), 'yyyy-MM-dd hh:mm');
        data.push(item);
    });

    const handleDelete = id => () => {
        axios.delete('/api/timetable/' + id)
            .then(() => {
                message.success('Grafikas ištrintas');
            })
            .catch((error) => {
                console.log(error);
            });
    }

    return (
        <>
            <Card>
                <h3>Darbo grafikas</h3>
                <List
                    size="large"
                    bordered
                    dataSource={data}
                    renderItem={item => <List.Item
                        actions={isAdminMode ?
                            [<a key="1" onClick={handleDelete(item.id)} >ištrinti</a>] : null}
                    >{"Nuo " + item.timetable_start + " iki " + item.timetable_end + " | " + item.comment}</List.Item>}
                />
            </Card>
            {isAdminMode ?
                <Card>
                    <h3>Pridėti naują</h3>
                    <TimetableForm userId={userId} />
                </Card>
                : null}
        </>
    );
};

export default Timetable;
