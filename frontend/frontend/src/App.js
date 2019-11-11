import React from 'react'
import './CSS/App.css'
import TodoItems from './Components/TodoItems'



function App() {
  return (
    <div className="App">
      <div className ="Container">
        <h1>~ Todo List ~</h1>
        <TodoItems/>
      </div>
     
    </div>
  )
}
export default App;