package com.example.multimodule.controller;

import com.example.multimodule.command.CommandDispatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final CommandDispatcher commandDispatcher;

    public HelloController(CommandDispatcher commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam String channel) {
        commandDispatcher.push(channel, channel);
        return "Hello, World in Library!";
    }
}
