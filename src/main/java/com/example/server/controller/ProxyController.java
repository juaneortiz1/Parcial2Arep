package com.example.server.controller;

import com.example.server.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class ProxyController {
private static final String template = "Hello, %s!";
private final AtomicLong counter = new AtomicLong();

@GetMapping("/request")
public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
}

}
