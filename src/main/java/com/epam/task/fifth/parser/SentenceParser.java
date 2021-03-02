package com.epam.task.fifth.parser;


import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SentenceParser extends AbstractParser {

    private static final String SEPARATOR = " ";
    private static final String MATH_EXPRESSION_REGEX = "\\[.*]";
    private static final Pattern MATH_EXPRESSION_PATTERN = Pattern.compile(MATH_EXPRESSION_REGEX);

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSeparator() {
        return SEPARATOR;
    }

    @Override
    public Component parse(String text) {

        List<String> lexemes = getLexemes(text);

        Parser successor = getSuccessor();

        List<Component> components = lexemes.stream()
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }

    private List<String> getLexemes(String text) {

        StringBuilder textBuilder = new StringBuilder(text);

        List<String> lexemes = new ArrayList<>();

        Matcher matcher = MATH_EXPRESSION_PATTERN.matcher(textBuilder);

        while (matcher.find()) {
            String expression = matcher.group();

            int expressionStart = matcher.start();
            int expressionEnd = matcher.end();

            String textBeforeExpression = textBuilder.substring(0, expressionStart);

            String[] words = textBeforeExpression.split(SEPARATOR);

            lexemes.addAll(Arrays.asList(words));
            lexemes.add(expression);

            textBuilder.replace(0, expressionEnd, "");
        }

        String remainingText = textBuilder.toString();

        if (remainingText.length() > 0 && !remainingText.matches(SEPARATOR)) {
            String[] words = remainingText.split(SEPARATOR);
            lexemes.addAll(Arrays.asList(words));
        }

        return lexemes;
    }
}