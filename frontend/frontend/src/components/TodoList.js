import React from './node_modules/react';
import PropTypes from './node_modules/prop-types';
import Button from '../Button'
//Lager todolista
function Task( {task, deleteTask}) {
  let {id, content} = task;
  return (
    <tr>
      <td>{content}</td>
    <td> <Button onClick={() => deleteTask(id)}> Delete </Button>
    </td>
    </tr>
    
  );
}

// Validerer dataen vi får inn, dette er for å bug-checke
Task.propTypes = {
  task: PropTypes.object.isRequired,
  deleteTask: PropTypes.func.isRequired,
};

export default function TaskList (props) {
  let { deleteTask, tasks, filterText } = props;
  let taskList = tasks
    .filter(task =>
      task.name.toLowerCase().includes(filterText.toLowerCase()),
      )
    .map(task => (
      <Task
        deleteTask={deleteTask}
        task={task}
        key={task.id}
      />
    ));

    return (
      <table>
        <thead>
        <tr>
          <th>Task</th>
          <th>Delete</th>
        </tr>
        </thead>
      </table>
    )
}

TaskList.propTypes = {
  tasks: PropTypes.array.isRequired,
  deleteTask: PropTypes.func.isRequired,
  filterText: PropTypes.string.isRequired,
};
