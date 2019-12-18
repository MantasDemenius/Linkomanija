import React, { useEffect, useCallback, useState } from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { List, message } from 'antd';
import { useHistory } from "react-router-dom";
import axios from 'axios';

const UserList = () => {
    const [clients, setClients] = useState([]);
    const [employees, setEmployees] = useState([]);
    const [state, updateState] = React.useState();
    const forceUpdate = useCallback(() => updateState({}), []);
    let history = useHistory();

    useEffect(() => {
        axios.get('/api/user/employee')
            .then((res) => {
                setEmployees(res.data);
            })
        axios.get('/api/user/client')
            .then((res) => {
                setClients(res.data);
            })
    }, [state]);

    const data = [];

    employees.forEach(employee => {
        data.push(employee);
    })

    clients.forEach(employee => {
        data.push(employee);
    })

    const handleEmployeeDelete = id => () => {
        axios.delete('/api/user/employee/' + id)
            .then(() => {
                message.success('Darbuotojas ištrintas');
                forceUpdate();
            })
            .catch(() => {
                message.success('Darbuotojo ištrinti nepavyko');
            });
    }

    const handleClientDelete = id => () => {
        axios.delete('/api/user/client/' + id)
            .then(() => {
                message.success('Klientas ištrintas');
                forceUpdate();
            })
            .catch(() => {
                message.success('Kliento ištrinti nepavyko');
            });
    }

    const handleTimetableClick = id => () => {
        history.push('/grafikas/' + id);
    }

    return (
        <List
            className="demo-loadmore-list"
            itemLayout="horizontal"
            dataSource={data}
            renderItem={item => (
                <List.Item
                    actions={item.movieTheatre ?
                        [<a key="1" onClick={handleTimetableClick(item.id)}>grafikas</a>, <a key="2" onClick={handleEmployeeDelete(item.id)} >ištrinti</a>] :
                        [<a key="2" onClick={handleClientDelete(item.id)}>ištrinti</a>]}
                >
                    {item.username + " " + item.name + " " + item.surname + " " + item.email}
                </List.Item>
            )}
        />
    )
}

export default UserList;