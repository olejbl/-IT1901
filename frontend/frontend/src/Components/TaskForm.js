import React, { useState } from 'react';
import PropTypes from 'prop-types'; //for tilstandskontroll og bug-check
import Input from '../Input/Input';
import './TaskForm.css'

const defaultState = {
    content: '',
};

function TaskForm(props) {
    let {addTask} = props;
    let [task, setTask] = useState(defaultState);

    let handleFieldChange = event => {
        const value = event.target.value;
        const name = event.target.name;
        setTask({ ...task, [name]: value});
        console.log("Value: ", value);
        console.log("Content : ", content);
        console.log("TasK: ", task);
        
    };
    let {content} = task;
    console.log("content", content)

    let submitTask = evt => {
        evt.preventDefault(); //for å slippe å reloade på submit
        addTask({content, id: new Date().getTime() });
        console.log("THIS IS THE TASK", task)
        setTask(defaultState);
        console.log("dfSt " + defaultState.content);
    };
    
    return (
        <form onSubmit={submitTask}>
            <Input
                name="content"
                type="text"
                onChange={handleFieldChange}
                label="Add task: "
                value={content.toString()}
            />
            <Input className="btnSend" name="submit" type="submit" />
        </form>
    );
}

TaskForm.propTypes = {
    addTask: PropTypes.func.isRequired,
}
export default TaskForm;