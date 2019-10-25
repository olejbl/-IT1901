import React, { Component } from 'react';
//import AddTodo from './AddTodo';

/*
handleAdd = (word) => {
    console.log(word)
}
*/

class Button extends Component {
  state = {}
  render() {
    return ( < div >

      <button /*onClick={( ) => this.handleAdd(word)}*/ className="btn btn-secondary btn-sm" >
          Add
      </button> 
      </div>
    );
  }
}


export default Button;
