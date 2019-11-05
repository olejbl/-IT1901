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

        
        let headers = new Headers();

         //headers.append('Content-Type', 'application/json');
         //headers.append('Accept', 'application/json');
         headers.append('Origin','http://localhost:8080');

        
        const url = 'http://localhost:8080/save';
        fetch(url, {
            crossDomain:true,
            method: 'POST',
            mode: 'no-cors',
            credentials: 'include',
            headers: headers,
            body: JSON.stringify({
            firstParam: 'yourValue',
            secondParam: 'yourOtherValue',
            })})

        .then(response => response.text())
            .then(contents => console.log(contents))
            .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))
            
        
    
        
    }
   
    
    return (
        <form onSubmit={submitTask}>
            <Input
                name="content"  
                type="text"
                onChange={handleFieldChange}
                label="Task: "
                value={content.toString()}
            />
            <Input className="btn" name="submit" type="submit" />
        </form>
    );
    }

TaskForm.propTypes = {
    addTask: PropTypes.func.isRequired,
}

export default TaskForm;