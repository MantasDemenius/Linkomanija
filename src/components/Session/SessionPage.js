import React, { useEffect, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography, Table, Divider, Button } from 'antd';
import { Select } from 'antd';
import { format, addDays, startOfToday } from 'date-fns';
import { lt } from 'date-fns/locale';
import { useHistory } from 'react-router-dom';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
const { Option } = Select;
const { Title } = Typography;

const SessionPage = () => {
  const history = useHistory();
  const [sessions, setSessions] = useState([]);
  const user = useSelector((store) => store.client.userType);
  useEffect(() => {
    axios
      .get('/api/session')
      .then((res) => {
        console.log(res.data[0].movie);
        setSessions(res.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  const loadDataSource = () => {
    console.log('aa');

    sessions.map((session) => {
      console.log('a', session);
      dataSource.push({
        key: session.id,
        place: session.movieHall.movieTheatre.name,
        token: 'a',
        time: session.session_start,
        title: session.movie.title,
      });
    });
  };
  const dataSource = [];

  const columns = [
    {
      title: 'Place',
      dataIndex: 'place',
      key: 'place',
      width: 200,
      render: (text) => <Title level={4}>{text}</Title>,
    },
    {
      title: 'Time',
      dataIndex: 'time',
      key: 'time',
      width: 150,
      render: (text) => <Title level={4}>{text}</Title>,
    },
    {
      title: 'Title',
      dataIndex: 'title',
      key: 'title',
      render: (text) => <Title level={4}>{text}</Title>,
    },
    {
      title: 'Action',
      key: 'action',
      align: 'right',
      render: (item) => (
        <>
        {user !== '' &&<>
        <Button type="primary"  onClick={() =>  history.push(`/seansas/${item.key}/rezervuoti`)} style={{margin: "5px"}}>Rezervuoti</Button>
          <Button type="primary"  onClick={() =>  history.push(`/seansas/${item.key}/pirkti`)} >Pirkti</Button>
          </>}
          {user === 'admin' && <Button
            type="secondary"
            onClick={() => history.push(`/seansas/redaguoti/${item.key}`)}
            size="default"
          >
            Redaguoti
          </Button>}
        </>
      ),
    },
  ];
  const options = [];
  const today = startOfToday();
  for (let i = 0; i < 7; i++) {
    const date = addDays(today, i);
    let formattedDate = format(date, 'MMMM dd', { locale: lt });
    if (i === 0) formattedDate = 'Šiandien';
    if (i === 1) formattedDate = 'Rytoj';
    options.push(
      <Option key={i}>{formattedDate.charAt(0).toUpperCase() + formattedDate.slice(1)}</Option>,
    );
  }

  function handleChange(value) {
    console.log(`selected ${value}`);
  }

  return (
    <Card>
      <Select defaultValue="0" style={{ width: 150 }} onChange={handleChange}>
        {options}
      </Select>
      {user === 'admin' && <Button onClick={() => history.push('/seansas/prideti')}>Pridėti seansą</Button>}
      {loadDataSource()}
      <Divider style={{ marginBottom: 0 }} />
      <Table dataSource={dataSource} columns={columns} showHeader={false} pagination={false} />

    </Card>
  );
};

export default SessionPage;
