package com.dianawu.todo.service.impl;

import com.dianawu.todo.dto.TodoDto;
import com.dianawu.todo.entity.Todo;
import com.dianawu.todo.repository.TodoRepository;
import com.dianawu.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // Lombok annotation to create a constructor with all the required arguments (DI)
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // convert DTO to entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());


        // Persist entity to database
        Todo savedTodo = todoRepository.save(todo);

        // Convert save Todo JPA entity to DTO
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());

        return savedTodoDto;
    }
}
