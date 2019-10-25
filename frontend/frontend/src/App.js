
import React, { Component } from 'react';
import Button from './Components/Button';
import AddTodo from './AddTodo';
//import Todos from 'Todos';



class App extends Component {
  constructor (props){super(props) }
  state = {
    todos: [ "test"],
}

  onChangeValue = () => {
     // this.setState({value: event.target.value});
  }

  onAddItem = () =>{
    this.setState(state => {const todos = state.todos.push(state.value)
    return {
      todos, value: '',
    }})

  }

  render() {
    return ( < div className="Container" >
     <h1 className="center blue-text">Todo</h1>
     {/*<AddTodo addTodo={ this.addTodo }></AddTodo>*/}
    <button type='button' onClick={this.onAddItem}> add</button>
    <input type='text' value={this.state.value} onChange= {this.onChangeValue}></input>
    {/*<Todos todos={this.state.todos}></Todos> */}
    <div> 
      <ul>{ this.state.todos.map(item => (
      <li key={item}>{item}</li>
    ))} </ul>
    </div>
    </div >
    );
  }
}


export default App;