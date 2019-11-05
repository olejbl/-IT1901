import React from 'react'
import './App.css'
import TodoItems from './Components/TodoItems'



function App() {
  return (
    <div className="App">
      <div className ="Container">
        <h1>TodoList App</h1>
        <TodoItems/>
      </div>
     
    </div>
  )
}
export default App;