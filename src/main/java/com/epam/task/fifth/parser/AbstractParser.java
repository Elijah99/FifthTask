package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractParser implements Parser{

    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;

    }

    protected abstract String getSeparator();

    protected Parser getSuccessor() {
        return successor;
    }

    @Override
    public Component parse(String text) {

        String separator = getSeparator();

        String[] parts = text.split(separator);

        Parser successor = getSuccessor();

        List<Component> components = Arrays.stream(parts)
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }

}
