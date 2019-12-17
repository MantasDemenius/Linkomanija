import React from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import './filter.css'
import { Card } from 'antd';
import { Checkbox } from 'antd';
import { Typography } from 'antd';

const { Text } = Typography;

const languages = [
    { label: 'Lietuvių', value: 1 },
    { label: 'Русский', value: 3 },
    { label: 'English', value: 2 },
];

const censorhips = [
    { label: 'V', value: 'V' },
    { label: 'N-7', value: 'N-7' },
    { label: 'N-16', value: 'N-16' },
];

const genres = [
    { label: 'Animacinis', value: 1 },
    { label: 'Biografinis', value: 2 },
    { label: 'Drama', value: 3 },
    { label: 'Fantastinis', value: 4 },
    { label: 'Komedija', value: 5 },
    { label: 'Kriminalinis', value: 6 },
    { label: 'Nuotykių', value: 7 },
    { label: 'Opera', value: 8 },
    { label: 'Romantinė komedija', value: 9 },
    { label: 'Šeimos filmas', value: 10 },
    { label: 'Siaubo', value: 11 },
    { label: 'Trileris', value: 12 },
    { label: 'Veiksmo', value: 13 },
];

const Filter = ({ onChangeLanguage, onChangeCensorhip, onChangeGenre }) => {
    return (
        <>
            <Card>
                <Text strong>Kalba</Text>
                <Checkbox.Group options={languages} onChange={onChangeLanguage} />
            </Card>
            <Card>
                <Text strong>Amžiaus cenzas</Text>
                <Checkbox.Group options={censorhips} onChange={onChangeCensorhip} />
            </Card>
            <Card>
                <Text strong>Žanras</Text>
                <Checkbox.Group options={genres} onChange={onChangeGenre} />
            </Card>
        </>
    )
}

export default Filter;