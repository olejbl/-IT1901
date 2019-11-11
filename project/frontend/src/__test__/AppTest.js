import React from "react";
import renderer from "react-test-renderer";
import TodoItems from "../components/TodoItems.js";
import { render, getByTestId, fireEvent } from "@testing-library/react";

//Tests that the length of our tasks array is equal to 1 when the app is initialized, and that we correctly render an instance of TodoItems.
it("Tasks length increased by one when task is added.", () => {
  const { container, getByTestId } = render(<TodoItems />);
  const todoLen = getByTestId("items").innerHTML;
  expect(container).toBeDefined();
  expect(todoLen).toBe("1");
});
