package com.example.multimodule.command;

import java.util.function.Predicate;

public interface CommandFilter {
    void addFilter(String commandName, Predicate<String> filter);

    void setDefaultFilter(String commandName, Predicate<String> filter);

    void filter(String messageEvent);
}
