import React from 'react';
import '../CSS/Button.css'

export default function Button(props) {
    return (
        <button className="btn" {...props} />
    );
}