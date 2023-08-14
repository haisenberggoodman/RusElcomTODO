/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webvasev.ruselcomtodo.dao;

import com.webvasev.ruselcomtodo.entity.Todo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Администратор
 */
public class TodoDAOImpl implements TodoDAO{



    @PersistenceContext(name = "Todo") // нет необходимости использовать EntityManagerFactory
    private EntityManager entityManager;

    public TodoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Todo todo) {
        entityManager.persist(todo);
    }

    @Override
    public void update(Todo todo) {
        entityManager.merge(todo);
    }

    @Override
    public void delete(Long id) {
        Todo todo = entityManager.find(Todo.class, id);
        entityManager.refresh(todo);
    }

    @Override
    public Todo getById(Long id) {
        return entityManager.find(Todo.class, id);
    }

    @Override
    public List<Todo> getAll() {
        return entityManager.createQuery("select t from Todo t", Todo.class).getResultList();
    }
    
    
    
}
