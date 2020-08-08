package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController

public class HelloWorld {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello World";
    }

    //http://localhost:8080/homepage/rick/ghosh/5
    @RequestMapping(value = "/homepage/{name}/{lname}/{id}", method = GET)
    public String home(@PathVariable("name") String name,@PathVariable("lname") String lname, @PathVariable("id") long id)
    {
        return "Home Page "+ name + lname + id;

    }

    //http://localhost:8080/param?id=5
    @RequestMapping(value = "/param")
    public String param(@RequestParam("id") long id){

        return "id  = " + id;
    }

        // http://localhost:8080/mparam?id=5&name=rick
    @RequestMapping(value = "/mparam", params = { "id", "name" }, method = GET)
    public String multiParam(@RequestParam("id") long id, @RequestParam("name") String name){
        return "id  = " + id + name;
    }
}
