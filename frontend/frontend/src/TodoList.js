import React from 'react';

function Todo(props){
    return (
        <tr>
            <td>
                {props.desc}
            </td>
            <td><Button onClick={() => props.handleDeleteProduct(props.index)}>Delete ></Button></td>
           
        </tr>
    );
}


function TodoList(props) {
    let TodoList = props.products
      .filter(todo => true)
      .map((todo, index) => <Todo key={index} index={index} handleDeleteTodo={props.handleDelete} {...todo} />);
  
    return (
      <table>
        <thead>
          <tr>
            <th>Description</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>{TodoList}</tbody>
      </table>
    );
  }
  
