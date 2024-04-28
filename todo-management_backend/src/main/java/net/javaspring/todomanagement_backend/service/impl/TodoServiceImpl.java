package net.javaspring.todomanagement_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaspring.todomanagement_backend.dto.TodoDto;
import net.javaspring.todomanagement_backend.entity.Todo;
import net.javaspring.todomanagement_backend.exception.ResourceNotFoundException;
import net.javaspring.todomanagement_backend.repository.TodoRepository;
import net.javaspring.todomanagement_backend.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    TodoRepository todoRepository;


    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto tododto) {
       Todo todo = modelMapper.map(tododto, Todo.class);

       Todo savedTodo = todoRepository.save(todo);

       TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodoById(int id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Todo with the id "+ id+ " not found"));

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> allTodos = todoRepository.findAll();
       return  allTodos.stream().map(todoDto -> modelMapper.map(todoDto, TodoDto.class)).collect(Collectors.toList());

    }

    @Override
    public TodoDto updateTodo(int id, TodoDto todoDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Todo with the id "+ id+ " not found"));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);


    }

    @Override
    public String deleteTodo(int todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(()->new ResourceNotFoundException("Todo with the id "+ todoId+ " not found"));
        todoRepository.delete(todo);
        return "Todo deleted successfully";
    }

    @Override
    public TodoDto completeTodo(int id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Todo Not Found with id "+id));
        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto incompleteTodo(int id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Todo Not Found with id "+id));
        todo.setCompleted(Boolean.FALSE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

}
