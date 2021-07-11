package com.example.multimodule.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommandDispatcherImpl implements CommandDispatcher{
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandDispatcherImpl.class);

    private Map<String, BaseCommandHandler> commandHandlers = new HashMap<>();

    @Override
    public void register(String channel, BaseCommandHandler handler) {
        LOGGER.info("Register command handler: {}", channel);
        commandHandlers.put(channel, handler);
    }

    @Override
    public void push(String channel, String command) {
        LOGGER.info("Looking for command handler for {}", channel);
        BaseCommandHandler handler = commandHandlers.get(channel);
        if (handler != null) {
            handler.onCommand((command));
        }
    }
}
