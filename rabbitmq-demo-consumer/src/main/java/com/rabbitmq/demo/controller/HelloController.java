package com.rabbitmq.demo.controller;

import com.rabbitmq.demo.controller.form.Person;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/demo")
public class HelloController {

    @RequestMapping("/test/{id}")
    public String test(@NotNull(message = "id不能为空") @PathVariable Integer id){
        System.out.println("--------------"+id+"-------------");
        return "123";
    }

    @RequestMapping("/test2")
    public String test2(@Valid @NotNull(message = "id不能为空") @RequestParam Integer id){
        System.out.println("--------------"+id+"-------------");
        return "123";
    }

    @RequestMapping("/test3")
    public String test3(@Valid @RequestBody Person person){
        return "123";
    }

}
