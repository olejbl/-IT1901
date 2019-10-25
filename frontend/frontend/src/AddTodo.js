import React, { Component } from 'react';

class AddTodo extends Component {
    state = { 
        content:" "

     }

     handleChange = (word) => {
         this.setState({
             content: word.target.value

         })
     }
    render() { 
        return ( 
            <div>
                <form>
                    <label>Add new Todo:</label>
                    <input type="text" ></input>
                </form>
            </div>

         );
    }
}
 
export default AddTodo;