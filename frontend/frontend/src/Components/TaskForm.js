import React, {useState} from './node_modules/react';
import PropTypes from './node_modules/prop-types'; //for tilstandskontroll og bug-check
import Input from '../Input/Input';

const defaultState = {
    content: '',
};

function TaskForm(props) {
    let {addTask} = props;
    let [task, setTask] = useState(defaultState);

    let handleFieldChange = event => {
        const value = event.target.value;
        const content = event.target.content
        setTask({ ...task, [content]: value});
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
                content="content"
                type="text"
                onChange={handleFieldChange}
                label="Task: "
                value={content}
            />
            <Input className="btn" name="submit" type="submit" />
        </form>
    );
}

TaskForm.PropTypes = {
    addTask: PropTypes.func.isRequired,
}
export default TaskForm;