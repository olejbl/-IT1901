import React, { useState} from 'react';
import Input from '../Components/Input'


const defaultState = {
    desc: '',

};

function TodoForm(props) {
    let [todo, setTodo] = useState(defaultState);

    let handleFieldChange = event => {
        const value = event.target.value;
        const desc = event.target .desc;
    };

    let submitTodo = evt => {
        evt.preventDefault();
    };

    let { desc} = todo; 

    return (
        <form>
            <Input onChange  ={handleFieldChange} name="desc" type="text" label="Description: " value={desc}></Input>
            <Input className= "btn" name="submit " type ="submit"></Input>
        </form>
    );
}

export default TodoForm;