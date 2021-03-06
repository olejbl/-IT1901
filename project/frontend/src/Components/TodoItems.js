import React, {useState, useEffect} from 'react';
import TaskForm from './TaskForm';
import TaskList from './TodoList';
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
      //setTasks(res.data.wordList);
      console.log(res.data.wordList)
      const arr = res.data.wordList;
      let pp = arr.filter( (ele, ind) => ind === arr.findIndex( elem => elem.id === ele.id))
      setTasks(pp);

      console.log(pp)
    })
    .catch(function(err) {
      console.log('Fetch error: ' , err);
    });

  }, []);



  let handleAddTask = task => {
    setTasks(tasks.concat(task));
    console.log("handleAddTask content: " + JSON.stringify(task))
  };

  let handleDeleteTask = id => {
    setTasks(tasks.filter((task) => task.id !== id));
  };


  return (
    <div className="tasks">
      <TaskList
        deleteTask={handleDeleteTask}
        tasks={tasks}
      />
      <TaskForm addTask={handleAddTask} />
      <p data-testid="items">Tasks length:{tasks.length}</p>
    </div>
  )
}