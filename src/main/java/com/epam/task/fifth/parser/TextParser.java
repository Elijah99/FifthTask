package com.epam.task.fifth.parser;

public class TextParser extends AbstractParser {

    private static final String SEPARATOR = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSeparator() {
        return SEPARATOR;
    }
}
