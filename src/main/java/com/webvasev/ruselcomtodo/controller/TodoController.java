package com.webvasev.ruselcomtodo.controller;

import com.webvasev.ruselcomtodo.dao.TodoDAO;
import com.webvasev.ruselcomtodo.dao.TodoDAOImpl;
import com.webvasev.ruselcomtodo.entity.Todo;
import com.webvasev.ruselcomtodo.service.TodoService;
import com.webvasev.ruselcomtodo.service.TodoServiceImpl;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named
@ViewScoped
public class TodoController implements Serializable {
    private TodoService todoService;
    private List<Todo> todos;
    private Todo newTodo;

    @Inject
    public TodoController(EntityManager entityManager) {
        TodoDAO todoDAO = new TodoDAOImpl(entityManager);
        todoService = new TodoServiceImpl(todoDAO);
    }


    @PostConstruct
    public void init() {
        todos = todoService.getAll();
        newTodo = new Todo();
    }


    public void saveTodo() {
        newTodo.setCreationTime(LocalDate.now());
        todoService.save(newTodo);
        todos = todoService.getAll();
        newTodo = new Todo();
    }

    public void deleteTodo(Long id) {
        todoService.delete(id);
        todos = todoService.getAll();
    }

    public TodoService getTodoService() {
        return todoService;
    }

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Todo getNewTodo() {
        return newTodo;
    }

    public void setNewTodo(Todo newTodo) {
        this.newTodo = newTodo;
    }
}
