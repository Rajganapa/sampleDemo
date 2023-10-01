package sampleSpringApplicationDemo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping
    public String defaultMethod(){
        return "Welcome to SpringBoot Demo";

    }
    @GetMapping(value ="/demo")
    public String byMappingMethod(){
        return "Getmapping";
    }
}
