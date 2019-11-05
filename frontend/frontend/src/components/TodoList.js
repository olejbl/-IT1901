import React from 'react';
import PropTypes from 'prop-types';
import Button from './Button'
import './TodoList.css'

//Lager todolista
function Task( {task, deleteTask}) {
  let {id, content} = task;
  return (
    <tr className="TableItems">
      <td>{content}</td>
    <td> <Button onClick={() => deleteTask(id)}> Delete </Button>
    </td>
    </tr>
    
  );
}

export default function TaskList (props) {
  let { deleteTask, tasks } = props;
  let taskList = tasks
    .map(task => (
      <Task
        deleteTask={deleteTask}
        task={task}
        key={task.id}
      />
    ));

    return (
      <table >
        <thead >
        <tr>
          <th>Task</th>
          <th>Delete</th>
        </tr>
        </thead>
        <tbody >{taskList}</tbody>
      </table>
    )
}
// Validerer dataen vi får inn, dette er for å bug-checke
Task.propTypes = {
  task: PropTypes.object.isRequired,
  deleteTask: PropTypes.func.isRequired,
};
