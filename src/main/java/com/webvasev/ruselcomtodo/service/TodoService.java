/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webvasev.ruselcomtodo.service;

import com.webvasev.ruselcomtodo.entity.Todo;
import java.util.List;

/**
 *
 * @author Администратор
 */
public interface TodoService {
    void save(Todo todo);
    void update(Todo todo);
    void delete(Long id);
    Todo getById(Long id);
    List<Todo> getAll();
    List<Todo> getActiveTodos();
    List<Todo> getImportantTodos();
    List<Todo> getOverdueTodos();
}
