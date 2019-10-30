import React, { Component } from 'react'
import './App.css'
import logo from './logo.svg';
import TodoItems from './Components/TodoItems'

function App() {
  return (
    <div className="App">
      <div>
        <img src={logo} className="App-logo"/>
        <h1>TodoList App</h1>
      </div>
      <TodoItems/>
    </div>
  )
}
export default App;