import React from 'react';
import PropTypes from 'prop-types';
import Button from './Button'
import '../CSS/TodoList.css'
import '../CSS/TodoItems.css'

//Lager todolista
function Task( {task, deleteTask}) {
  let {id, content} = task;
  return (
    <tr className="tableItems">
      <td>{content}</td>
    <td className="btnContainer"> <Button onClick={() => deleteTask(id)}> Delete </Button>
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
      <table className="table">
        <thead >
        <tr>
          <th>Task</th>
          <th className="delLabel">Delete</th>
        </tr>
        </thead>
        <tbody>{taskList}</tbody>
      </table>
    )
}
// Validerer dataen vi får inn, dette er for å bug-checke
Task.propTypes = {
  task: PropTypes.object.isRequired,
  deleteTask: PropTypes.func.isRequired,
};
