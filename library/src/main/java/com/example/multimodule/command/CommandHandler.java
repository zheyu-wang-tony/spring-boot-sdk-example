package com.example.multimodule.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

public abstract class CommandHandler implements BaseCommandHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandHandler.class);

//    private CommandFilter commandFilter;

    private CommandDispatcher commandDispatcher;

//    public void setCommandFilter(CommandFilter commandFilter) {
//        this.commandFilter = commandFilter;
//    }

    public void setCommandDispatcher(CommandDispatcher commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    private void register() {
        init();
        commandDispatcher.register(getCommandName(), this);
//        commandFilter.addFilter(getCommandName(), getCommandMatcher());
    }

    private String getCommandName() {
        String[] list = this.getClass().getCanonicalName().split("\\.");
        return list[list.length - 1];
    }

    protected void init() {
    }

    @Override
    public void onCommand(String command){
        handle(command, command);
    }

//    protected abstract Predicate<String> getCommandMatcher();

    public abstract void handle(String command, final String commandResponse);

}
