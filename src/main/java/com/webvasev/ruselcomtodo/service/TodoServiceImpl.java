/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webvasev.ruselcomtodo.service;

import com.webvasev.ruselcomtodo.dao.TodoDAO;
import com.webvasev.ruselcomtodo.entity.Todo;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Администратор
 */
public class TodoServiceImpl implements TodoService {

    private TodoDAO todoDAO;
    
    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }
    
    @Override
    public void save(Todo todo) {
        todoDAO.save(todo);
    }

    @Override
    public void update(Todo todo) {
        todoDAO.update(todo);
    }

    @Override
    public void delete(Long id) {
        todoDAO.delete(id);
    }

    @Override
    public Todo getById(Long id) {
       return todoDAO.getById(id);
    }

    @Override
    public List<Todo> getAll() {
        return todoDAO.getAll();
    }

    @Override
    public List<Todo> getActiveTodos() {
        return todoDAO.getAll().stream()
                .filter(Todo::isCompleted) 
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> getImportantTodos() {
        return todoDAO.getAll().stream()
                .filter(Todo::isImportant)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> getOverdueTodos() {
        LocalDate today = LocalDate.now();
        return todoDAO.getAll().stream()
                .filter(todo -> !todo.isCompleted() && todo.getDueDate().isBefore(today))
                .collect(Collectors.toList());
    }
    
}
