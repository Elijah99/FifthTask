package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;

public class LexemeParser implements Parser {

    private static final String EXPRESSION_REGEX = "\\[.*]";

    public LexemeParser() {
    }


    @Override
    public Component parse(String text) {
        if (text.matches(EXPRESSION_REGEX)) {
            return new Leaf(LeafType.EXPRESSION, text);
        } else {
            return new Leaf(LeafType.WORD, text);
        }
    }
}
