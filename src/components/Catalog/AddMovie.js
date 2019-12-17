import React, { useCallback } from "react";
import 'antd/dist/antd.css'
import '../../App.css'
import { Card } from 'antd';
import { Typography } from 'antd';
import { Form, Input, Select, Button } from 'antd';
import { useHistory } from 'react-router-dom';
import { message } from 'antd';
import axios from 'axios';

const { Option } = Select;
const { TextArea } = Input;

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

const { Text } = Typography;
const AddMovie = ({ form, isEditMode, movie }) => {
    const { getFieldDecorator } = form;
    const history = useHistory();
    const [, updateState] = React.useState();
    const forceUpdate = useCallback(() => updateState({}), []);

    const handleSubmit = (e) => {
        e.preventDefault();

        form.validateFieldsAndScroll((err, values) => {
            console.log(values)

            if (!err) {
                if (isEditMode) {
                    axios.post('/api/movie/edit', { id: movie.id, ...values })
                        .then(() => {
                            message.success('Filmas pakeistas sėkmingai');
                            forceUpdate();
                        })
                        .catch(() => {
                            message.error('Blogas IMDb kodas');
                        });
                } else {
                    axios.post('/api/movie', values)
                        .then(() => {
                            message.success('Filmas sukurtas sėkmingai');
                            history.push('/movies');
                        })
                        .catch(() => {
                            message.error('Blogas IMDb kodas');
                        });
                }

            } else {
                console.log(err);
            }
        });
    };

    const genreOptions = [];
    genres.forEach((genre) => {
        genreOptions.push(<Option key={genre.value} value={genre.value}>{genre.label}</Option>);
    })

    return (
        <Card>
            <h2>{isEditMode ? "Filmo redagavimas" : "Filmo pridėjimas"}</h2>
            <Form onSubmit={handleSubmit}>
                <Form.Item label="Filmo pavadinimas">
                    {getFieldDecorator('title', {
                        rules: [{ required: true, message: 'Filmo pavadinimas privalomas' }],
                        initialValue: isEditMode ? movie.title : "",
                    })(
                        <Input placeholder="Filmo pavadinimas" />
                    )}
                </Form.Item>
                <Form.Item label="IMDb kodas">
                    {getFieldDecorator('imdb_code', {
                        rules: [{ required: true, message: 'IMDb kodas privalomas' }],
                        initialValue: isEditMode ? movie.imdb_code : "",
                    })(
                        <Input placeholder="Aprašymas" />
                    )}
                </Form.Item>
                <Form.Item label="Aprašymas">
                    {getFieldDecorator('description', {
                        rules: [{ required: true, message: 'Aprašymas privalomas' }],
                        initialValue: isEditMode ? movie.description : "",
                    })(
                        <TextArea placeholder="Aprašymas" />
                    )}
                </Form.Item>
                <Form.Item label="Amžiaus cenzas" hasFeedback>
                    {getFieldDecorator('age_censor', {
                        rules: [{ required: true, message: 'Pasirinkti amžiaus cenzą privaloma' }],
                        initialValue: isEditMode ? movie.age_censor : "V",
                    })(
                        <Select placeholder="Amžiaus cenzas">
                            <Option value="V">V</Option>
                            <Option value="N-7">N-7</Option>
                            <Option value="N-16">N-16</Option>
                        </Select>,
                    )}
                </Form.Item>
                <Form.Item label="Kalba" hasFeedback>
                    {getFieldDecorator('language_id', {
                        rules: [{ required: true, message: 'Pasirinkti kalbą privaloma' }],
                        initialValue: isEditMode && movie.language ? movie.language.id : 1,
                    })(
                        <Select placeholder="Kalba">
                            <Option value={1}>Lietuvių</Option>
                            <Option value={2}>Anglų</Option>
                            <Option value={3}>Rusų</Option>
                        </Select>,
                    )}
                </Form.Item>
                <Form.Item label="Žanrai" hasFeedback>
                    {getFieldDecorator('genre_list', {
                        rules: [{ required: true, message: 'Pasirinkti žanrą privaloma' }],
                        initialValue: isEditMode && movie.genreList ? movie.genreList.map(genre => genre.id) : [10, 13],
                    })(
                        <Select
                            mode="multiple"
                            placeholder="Pasirinkite žanrus"
                        >
                            {genreOptions}
                        </Select>,
                    )}
                </Form.Item>
                <Form.Item>
                    <Button type="primary" htmlType="submit">
                        Pateikti
                </Button>
                </Form.Item>
            </Form>
        </Card>
    )
}

export default Form.create()(AddMovie);

