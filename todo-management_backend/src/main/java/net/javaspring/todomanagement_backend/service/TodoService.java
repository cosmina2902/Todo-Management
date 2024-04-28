package net.javaspring.todomanagement_backend.service;

import net.javaspring.todomanagement_backend.dto.TodoDto;
import net.javaspring.todomanagement_backend.entity.Todo;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodoById(int id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(int id, TodoDto todoDto);

    String deleteTodo(int Id);

    TodoDto completeTodo (int id);

    TodoDto incompleteTodo(int id);
}
