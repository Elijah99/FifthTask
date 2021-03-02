package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ParagraphParserTest {

    public static final String FIRST_SENTENCE = "First sentence";
    public static final String SECOND_SENTENCE = "Second [1 2 -] sentence";
    public static final String TEXT_TO_PARSE = FIRST_SENTENCE + "..." + SECOND_SENTENCE + "?";
    public static final Component FIRST_SENTENCE_COMPONENT = new Composite(
            Arrays.asList(
                    new Leaf(LeafType.WORD, "First"),
                    new Leaf(LeafType.WORD, "Sentence")
            )
    );
    public static final Component SECOND_SENTENCE_COMPONENT = new Composite(
            Arrays.asList(
                    new Leaf(LeafType.WORD, "Second"),
                    new Leaf(LeafType.WORD, "[1 2 3 -]"),
                    new Leaf(LeafType.WORD, "sentence")
            )
    );

    public static final Component EXPECTED_COMPONENT = new Composite(Arrays.asList(FIRST_SENTENCE_COMPONENT, SECOND_SENTENCE_COMPONENT));


    @Test
    public void testParse() {
        //given
        Parser sentenceParser = Mockito.mock(SentenceParser.class);
        Parser paragraphParser = new ParagraphParser(sentenceParser);

        when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(FIRST_SENTENCE_COMPONENT);
        when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(SECOND_SENTENCE_COMPONENT);

        //when
        Component actual = paragraphParser.parse(TEXT_TO_PARSE);

        //then
        Assert.assertEquals(EXPECTED_COMPONENT, actual);
    }
}