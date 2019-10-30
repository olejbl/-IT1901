import React, { useState } from 'react';
import PropTypes from 'prop-types'; //for tilstandskontroll og bug-check
import Input from '../Input/Input';

const defaultState = {
    content: '',
};

function TaskForm(props) {
    let {addTask} = props;
    let [task, setTask] = useState(defaultState);

    let handleFieldChange = event => {
        const value = event.target.value;
        const content = event.target.name;
        setTask({ ...task, [content]: value});
        console.log("Value: ", value);
        console.log("Content : ", content);
        console.log("TasK: ", task);
        
    };

    let submitTask = evt => {
        evt.preventDefault(); //for å slippe å reloade på submit
        addTask({ ...content, id: new Date().getTime() });
        setTask(defaultState);
    };

    let {content} = task;
    return (
        <form onSubmit={submitTask}>
            <Input
                name="content"
                type="text"
                onChange={handleFieldChange}
                label="Task: "
                value={content}
            />
            <Input className="btn" name="submit" type="submit" />
        </form>
    );
}

TaskForm.propTypes = {
    addTask: PropTypes.func.isRequired,
}
export default TaskForm;