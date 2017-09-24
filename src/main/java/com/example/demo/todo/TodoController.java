package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoDao todoDao;


    @RequestMapping(method = RequestMethod.GET ,value="/todo/all")
    public List<Todo> getAll(){
        List<Todo> list = new ArrayList<>();
        for (Todo todo : todoDao.findAll())
            list.add(todo);
        return list;
    }

    @RequestMapping(method = RequestMethod.POST,value="/todo/create")
    public Todo create(  @RequestParam( required = true) String description,
                       @RequestParam(required = false) Long parentId){

        if(parentId != null && !todoDao.exists(parentId) ){
            return null;
        }
        Todo todo = new Todo();
        if(parentId != null && todoDao.exists((long)parentId) ){
            Todo parent = todoDao.findById(parentId);
            if(parent != null)
            System.out.println(parent.getId());
            else
                System.out.println("Parent is null");
            todo.setParent(parent);
        }
        todo.setDescription(description);
        return todoDao.save(todo);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/todo/delete")
    public void delete( @RequestParam Long id){
        todoDao.delete(id);
    }
}
