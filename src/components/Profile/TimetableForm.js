import React, { useEffect, useState } from 'react';
import 'antd/dist/antd.css';
import '../../App.css';
import { Card } from 'antd';
import { Typography } from 'antd';
import { Form, Input, Select, Button } from 'antd';
import { message } from 'antd';
import axios from 'axios';
import { DatePicker } from 'antd';

const { RangePicker } = DatePicker;


const TimetableForm = ({ form, userId }) => {
    const { getFieldDecorator } = form;

    const handleSubmit = e => {
        e.preventDefault();
        form.validateFieldsAndScroll((error, values) => {
            if (!error) {
                const dto = {
                    attending_date: values.range[0].format(),
                    timetable_start: values.range[0].format(),
                    timetable_end: values.range[1].format(),
                    comment: values.comment ? values.comment : "",
                    user_employee_id: userId
                }
                axios.post('/api/timetable', dto)
                    .then(() => {
                        message.success('Grafikas sukurtas');
                    }).catch(() => {
                        message.error('Grafiko sukurti nepavyko');
                    })
            }
        })
    }

    return (
        <>
            <Form onSubmit={handleSubmit} layout="inline">
                <Form.Item label="Laikas">
                    {getFieldDecorator('range', {
                        rules: [{ required: false, message: '' }]
                    })(
                        <RangePicker
                            showTime={{ format: 'HH:mm' }}
                            format="YYYY-MM-DD HH:mm"
                            placeholder={['Start Time', 'End Time']}
                        />
                    )}
                </Form.Item>
                <Form.Item label="Komentaras">
                    {getFieldDecorator('comment', {
                        rules: []
                    })(
                        <Input />
                    )}
                </Form.Item>
                <Form.Item>
                    <Button type="primary" htmlType="submit">
                        Pateikti
            </Button>
                </Form.Item>
            </Form>
        </>
    );
};

export default Form.create()(TimetableForm);