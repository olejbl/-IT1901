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
    };  
    let {content} = task;

    let submitTask = evt => {
        evt.preventDefault(); //for å slippe å reloade på submit
        setTask({content, id: new Date().getTime() });
        //sjekk om input er tom 
        if(!handleValidation({content})){
            alert("Input cannot be empty");
            return; 
        }
        addTask({content, id: new Date().getTime() });
       
        

        let headers = new Headers();
        headers.append('Origin','http://localhost:8080');

        const data = {
            wordList: [{
                content: content,
                id: new Date().getTime(),
            }]
        }
        
        const url = 'http://localhost:8080/save';
        fetch(url, {
            crossDomain:true,
            method: 'POST',
            mode: 'no-cors',
            credentials: 'include',
            headers: headers, 
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            body: JSON.stringify(
                data
            )})

        .then(response => response.text())
            .then(contents => console.log(JSON.stringify(contents), " is the contents from fetch response /save POST"))
            .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))
    }

    let handleValidation = task =>{
        let errors = {};
        let formIsValid = true; 

        if (content === ''){
            formIsValid = false; 
            errors[content] = "Cannot be empty";
        }
        return formIsValid;
    }

  
    return (
        <form onSubmit={submitTask}>
            <Input
                name="content"  
                type="text"
                onChange={handleFieldChange}
                label="Add task: "
                value={content.toString()} />  
            <Input className="btnSend" name="submit" type="submit" />
        </form>
    );
    }

TaskForm.propTypes = {
    addTask: PropTypes.func.isRequired,
}

export default TaskForm;