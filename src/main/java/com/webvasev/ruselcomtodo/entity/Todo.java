    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.webvasev.ruselcomtodo.entity;

    import java.time.LocalDate;
    import javax.persistence.*;

    /**
     *
     * @author Администратор
     */

    @Entity
    @Table
    public class Todo {
        @Column(name = "id")
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "content")
        private String content;
        @Column(name = "creation_time")
        private LocalDate creationTime; // task's creation date
        @Column(name = "due_date")
        private LocalDate dueDate; // task's due date

        @Column(name = "completed")
        private boolean completed;
        @Column(name = "important")
        private boolean important;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public LocalDate getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(LocalDate creationTime) {
            this.creationTime = creationTime;
        }

        public LocalDate getDueDate() {
            return dueDate;
        }

        public void setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public boolean isImportant() {
            return important;
        }

        public void setImportant(boolean important) {
            this.important = important;
        }



    }
