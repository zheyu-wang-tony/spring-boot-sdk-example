package com.example.multimodule.application;

import com.example.multimodule.command.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

public class TestCommand extends CommandHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandHandler.class);

    @Override
    public void handle(String command, String commandResponse) {
        LOGGER.info("TestCommand get {}", command);
    }
}
