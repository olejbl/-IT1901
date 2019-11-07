import React, { Component } from 'react'
import './App.css'
import TodoItems from './Components/TodoItems'
import styled from 'styled-components'

const Button = styled.button`
  
`


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