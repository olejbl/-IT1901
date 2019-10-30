import React from 'react';
import PropTypes from 'prop-types';
import './Input.css';
function Input(props) {
  const { label } = props;
  return (
    <div className="form-control">
      {label && <label>{label}</label>}
      <input {...props} />
    </div>
  );
}
Input.propTypes = {
  label: PropTypes.string,
};
export default Input;