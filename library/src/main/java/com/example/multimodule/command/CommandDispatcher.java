package com.example.multimodule.command;

public interface CommandDispatcher {
    void register(String channel, BaseCommandHandler handler);

    void push(String channel, String command);
}
