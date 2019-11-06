import React, {useState, useEffect} from 'react';
import TaskForm from './TaskForm';
import TaskList from './TodoList';
import reqListener from './Client'
import Button from './Button';


export default function Tasks() {
  let [tasks, setTasks] = useState([

    {
      content: 'Dette er en eksempelopppgave (content i TodoItems)',
    }
  ]);
//  let klient = new Client();

  useEffect(() => {
    fetch('http://localhost:8080/all',{
      crossDomain:true,
      method: 'GET',
      mode: 'no-cors',
      credentials: 'include',
      }
    )
    .then(res => res.json())
    .then(function(response){
      console.log('TodoItems is fetching.. ',response);
      if (response.status !== 200){
        console.log('Fetching failed, response status: '+ response.status);
        return;
      }
      response.json().then(function(data){ //was data instead of tasks, testing
        console.log(data, " is a response");
      });
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
    <div className="Tasks">
      <h2>Tasks</h2>
      <TaskList
        deleteTask={handleDeleteTask}
        tasks={tasks}
      />
      <TaskForm addTask={handleAddTask} />
      <Button onClick= {reqListener}>Load</Button>
    </div>
  )
}