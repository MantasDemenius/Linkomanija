import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import './filter.css'
import { Card } from 'antd';
import { Checkbox } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;

const Filter = () => {
    return (
        <>
            <Card>
                <Text strong>Kalba</Text>
                <Checkbox>Lietuvių</Checkbox>
                <Checkbox>Русский</Checkbox>
                <Checkbox>English</Checkbox>
            </Card>
            <Card>
                <Text strong>Amžiaus cenzas</Text>
                <Checkbox>V</Checkbox>
                <Checkbox>N-7</Checkbox>
                <Checkbox>N-13</Checkbox>
                <Checkbox>N-16</Checkbox>
            </Card>
            <Card>
                <Text strong>Žanras</Text>
                <Checkbox>Animacinis</Checkbox>
                <Checkbox>Biografinis</Checkbox>
                <Checkbox>Drama</Checkbox>
                <Checkbox>Fantastinis</Checkbox>
                <Checkbox>Komedija</Checkbox>
                <Checkbox>Kriminalinis</Checkbox>
                <Checkbox>Nuotykių</Checkbox>
                <Checkbox>Opera</Checkbox>
                <Checkbox>Romantinė komedija</Checkbox>
                <Checkbox>Šeimos filmas</Checkbox>
                <Checkbox>Siaubo</Checkbox>
                <Checkbox>Trileris</Checkbox>
                <Checkbox>Veiksmo</Checkbox>
            </Card>
        </>
    )
}

export default Filter;