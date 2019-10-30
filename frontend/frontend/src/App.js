import React, { Component } from 'react'
import './App.css'
import TodoList from './Components/TodoList'
import TodoItems from './Components/TodoItems'

function App() {
  return (
    <div className="App">
      <div>
        <h1>TodoList AOPop </h1>
      </div>
      <TodoItems/>
    </div>
  )
}
export default App;