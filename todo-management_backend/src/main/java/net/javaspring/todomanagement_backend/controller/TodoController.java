package net.javaspring.todomanagement_backend.controller;


import lombok.AllArgsConstructor;
import net.javaspring.todomanagement_backend.dto.TodoDto;
import net.javaspring.todomanagement_backend.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
@CrossOrigin
public class TodoController {

    private TodoService todoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") int todoId){

        TodoDto todoDto = todoService.getTodoById(todoId);
        return ResponseEntity.ok(todoDto);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){

        List<TodoDto> allTodos = todoService.getAllTodos();
        return ResponseEntity.ok(allTodos);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/todo/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") int todoId, @RequestBody TodoDto todoDto){

        TodoDto upTodo = todoService.updateTodo(todoId, todoDto);

        return ResponseEntity.ok(upTodo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id){
        String message = todoService.deleteTodo(id);

        return ResponseEntity.ok(message);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("/todo/{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable int id){
       TodoDto updatedTodo = todoService.completeTodo(id);

       return ResponseEntity.ok(updatedTodo);

    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("/todo/{id}/incomplete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable int id){
        TodoDto updatedTodo = todoService.incompleteTodo(id);

        return ResponseEntity.ok(updatedTodo);

    }
}
