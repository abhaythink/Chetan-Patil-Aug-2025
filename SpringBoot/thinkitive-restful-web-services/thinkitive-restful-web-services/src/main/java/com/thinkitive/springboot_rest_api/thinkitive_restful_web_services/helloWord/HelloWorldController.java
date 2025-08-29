package com.thinkitive.springboot_rest_api.thinkitive_restful_web_services.helloWord;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HelloWorldController
{
    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world")
    public String helloWord()
    {
        return "Hello Word !";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWordBean()
    {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWordPathVariable(@PathVariable String name)
    {
        //return new HelloWorldBean("Hello World "+name);
        return new HelloWorldBean(String.format("Hello World %s",name));
    }
}
