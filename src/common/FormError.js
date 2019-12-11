import React from 'react';
import PropTypes from 'prop-types';

const FormError = ({ message, Tag, color }) => {
  return <Tag style={{ color, textAlign: 'center', marginBottom: '0px' }}>{message}</Tag>;
};

FormError.propTypes = {
  message: PropTypes.string.isRequired,
  Tag: PropTypes.string,
  color: PropTypes.string,
};
FormError.defaultProps = {
  Tag: 'p',
  color: 'red',
};

export default FormError;
