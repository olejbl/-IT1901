import React from "react";
import TestRenderer from "react-test-renderer";
import TodoItems from "../components/TodoItems.js";
import { render, fireEvent, getByTestId } from "@testing-library/react";
import App from "../App.js";
/*
//Test for array. Et element lagt til skal øke lengden med 1.
describe("Array with elements", () => {
  test("Add one element(string)", () => {
    new TodoItems();
    expect(tasks.length());
  });
});
*/

//Test for the tasks array.
it("Tasks length increased by one when task is added.", () => {
  let { todos } = render(<TodoItems />);
  expect(todos.tasks.length().toBe("1"));
});

//test
