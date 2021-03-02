package com.epam.task.fifth.parser;

import org.mockito.Mockito;
import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class SentenceParserTest {
    public static final String FIRST_LEXEME = "First";
    public static final String SECOND_LEXEME = "[1 2 +]";
    public static final String TEXT_TO_PARSE = FIRST_LEXEME + " " + SECOND_LEXEME;
    public static final Component FIRST_LEXEME_COMPONENT = new Leaf(LeafType.WORD, FIRST_LEXEME);
    public static final Component SECOND_LEXEME_COMPONENT = new Leaf(LeafType.WORD, SECOND_LEXEME);
    public static final Component EXPECTED_COMPONENT = new Composite(Arrays.asList(FIRST_LEXEME_COMPONENT, SECOND_LEXEME_COMPONENT));


    @Test
    public void testParse() {
        //given
        Parser lexemeParser = Mockito.mock(LexemeParser.class);
        Parser sentenceParser = new SentenceParser(lexemeParser);

        when(lexemeParser.parse(FIRST_LEXEME)).thenReturn(FIRST_LEXEME_COMPONENT);
        when(lexemeParser.parse(SECOND_LEXEME)).thenReturn(SECOND_LEXEME_COMPONENT);

        //when
        Component actual = sentenceParser.parse(TEXT_TO_PARSE);

        //then
        Assert.assertEquals(EXPECTED_COMPONENT, actual);

    }
}
