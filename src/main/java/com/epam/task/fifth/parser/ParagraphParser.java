package com.epam.task.fifth.parser;

public class ParagraphParser  extends AbstractParser{
    private static final String SEPARATOR = "((\\.{3})|\\.|!|\\?) ?";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSeparator() {
        return SEPARATOR;
    }
}
