package com.example.demo.todo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String description;

//    private List<Todo> childs;
//    public List<Todo> getChilds() {
//        return childs;
//    }
//
//    public void setChilds(List<Todo> childs) {
//        this.childs = childs;
//    }

    @ManyToOne
    private Todo parent;

    public Todo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Todo getParent() {
        return parent;
    }

    public void setParent(Todo parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
