import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card, Radio } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;

const Sorter = ({ onChange }) => {
    return (
        <Card>
            <Text strong>Rikiavimas</Text>
            <div>
                <Radio.Group defaultValue="a" buttonStyle="solid" onChange={onChange}>
                    <Radio.Button value={1}>A - Z</Radio.Button>
                    <Radio.Button value={2}>Z - A</Radio.Button>
                    <Radio.Button value={3}>Geriausi</Radio.Button>
                    <Radio.Button value={4}>Blogiausi</Radio.Button>
                </Radio.Group>
            </div>
        </Card>
    )
}

export default Sorter;