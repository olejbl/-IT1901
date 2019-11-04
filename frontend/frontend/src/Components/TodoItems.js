import React, {useState, useEffect} from 'react';
import ListFilter from './ListFilter';
import TaskForm from './TaskForm';
import TaskList from './TodoList';
import axios from 'axios';


export default function Tasks() {
  let [tasks, setTasks] = useState([

    {
      content: 'Dette er en eksempelopppgave (content i TodoItems)',
    }
  ]);
  //let [filterText, setFilterText] = useState('');

  useEffect(() => {
    fetch('/data.json')
    .then(response => response.json())
    .then(todos => setTasks(todos));
  }, []);


  fetch('http://localhost:8080/all')
  .then(function(response){
    if (response.status != 200){
      console.log('problem'+ response.status);
      return;
    }
    response.json().then(function(data){
      console.log(data);
    }) ;
  })
  .catch(function(err) {
    console.log('fetch error: ' , err);

  });

  let handleAddTask = task => {
    setTasks(tasks.concat(task));
    console.log("handleAddTask content: " + task)
  };

  let handleDeleteTask = id => {
    setTasks(tasks.filter((task) => task.id !== id));
  };

  
/*
  async componentDidiMount = () => {
    const respons = await fetch('./project/restApi/save.json');
    const body = await response.json();
    this.setState({content: content});
  };
  */

  return (
    <div className="Tasks">
      <h2>Tasks</h2>
      <TaskList
        deleteTask={handleDeleteTask}
        tasks={tasks}
      />
      <TaskForm addTask={handleAddTask} />
    </div>
  )
}