import React, {useState, useEffect} from 'react';
import TaskForm from './TaskForm';
import TaskList from './TodoList';
//import reqListener from './Client'
import Button from './Button';
import axios from "axios";



export default function Tasks() {
  let [tasks, setTasks] = useState([]);
  useEffect(() => {
    
    axios.get('http://localhost:8080/all',{
      crossDomain:true,
      method: 'GET',
      mode: 'no-cors',
      credentials: 'include',
      }
    )
    .then(function(res){
      console.log('TodoItems is fetching.. ',res);
      if (res.status !== 200){
        console.log('Fetching failed, response status: '+ res.status);
        return;
      }
      // set tasks here, importing from axios
      setTasks(res.data.wordList);
      console.log(res.data.wordList)
    })
    .catch(function(err) {
      console.log('Fetch error: ' , err);
    });

  }, []);


  

 // });

  let handleAddTask = task => {
    setTasks(tasks.concat(task));
    console.log("handleAddTask content: " + JSON.stringify(task))
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
    <div className="tasks">
      <TaskList
        deleteTask={handleDeleteTask}
        tasks={tasks}
      />
      <TaskForm addTask={handleAddTask} />
      <Button onClick= {console.log("Button:)")}>Load</Button>
    </div>
  )
}