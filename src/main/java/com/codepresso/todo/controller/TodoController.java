package com.codepresso.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.codepresso.todo.service.TodoService;
import com.codepresso.todo.vo.Result;
import com.codepresso.todo.vo.Todo;
import org.springframework.web.bind.annotation.*;



@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    @ResponseBody
    public List<Todo> getTodoList(){
        List<Todo> list = todoService.getTodoList();
        return list;
    }

    @PostMapping("/todo")
    @ResponseBody
    public Object addTodo(HttpServletResponse response, @RequestBody Todo todoParam) {
        Todo todo = new Todo(todoParam.getContent());
        todoService.addTodo(todo);

        response.setStatus(HttpServletResponse.SC_OK);
        return new Result(200, "Success");
    }

    @DeleteMapping("/todo/{id}")
    public Object deleteTodo(HttpServletResponse response, @PathVariable("id") String id) {
        todoService.deleteTodo(Integer.parseInt(id));

        response.setStatus(HttpServletResponse.SC_OK);
        return new Result(200, "Success");
    }

}
