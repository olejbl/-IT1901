import React, {useState, useEffect} from 'react';
import ListFilter from './ListFilter';
import './TodoItems.css';
import TaskForm from './TaskForm';
import TaskList from './TodoList';

export default function Tasks() {
  let [tasks, setTasks] = useState([

    {
      content: '(Dette er en eksempelopppgave) ',
    }
    
  ]);
  //let [filterText, setFilterText] = useState('');

  useEffect(() => {
    fetch('/data.json')
    .then(response => response.json())
    .then(todos => setTasks(todos));
  }, []);

  let handleAddTask = task => {
    setTasks(tasks.concat(task));
    console.log("handleAddTask content: " + task)
  };

  let handleDeleteTask = id => {
    setTasks(tasks.filter((task) => task.id !== id));
  };

  return (
    <div className="Tasks">
      <TaskList
        deleteTask={handleDeleteTask}
        tasks={tasks}
      />
      <TaskForm addTask={handleAddTask} />
    </div>
  )
}