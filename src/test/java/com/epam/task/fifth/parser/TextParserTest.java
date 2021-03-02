package com.epam.task.fifth.parser;

import org.junit.Test;
import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class TextParserTest {

    public static final String FIRST_PARAGRAPH = "First paragraph 111.";
    public static final String SECOND_PARAGRAPH = "Second... [1 2 -] Paragraph?";
    public static final String TEXT_TO_PARSE = FIRST_PARAGRAPH + "\n" + SECOND_PARAGRAPH;
    public static final Component FIRST_PARAGRAPH_COMPONENT = new Composite(
            Collections.singletonList(
                    new Composite(
                            Arrays.asList(
                                    new Leaf(LeafType.WORD, "First"),
                                    new Leaf(LeafType.WORD, "paragraph"),
                                    new Leaf(LeafType.WORD, "111")
                            )
                    )
            )
    );
    public static final Component SECOND_PARAGRAPH_COMPONENT = new Composite(
            Arrays.asList(
                    new Composite(
                            Arrays.asList(
                                    new Leaf(LeafType.WORD, "Second")
                            )
                    ),
                    new Composite(
                            Collections.singletonList(
                                    new Leaf(LeafType.EXPRESSION, "[1 2 -]")
                            )
                    ),
                    new Composite(
                            Collections.singletonList(
                                    new Leaf(LeafType.WORD, "Paragraph")

                            )
                    )
            )
    );
    public static final Component EXPECTED_COMPONENT = new Composite(Arrays.asList(FIRST_PARAGRAPH_COMPONENT, SECOND_PARAGRAPH_COMPONENT));


    @Test
    public void testParse() {
        //given
        Parser paragraphParser = Mockito.mock(ParagraphParser.class);
        Parser textParser = new TextParser(paragraphParser);

        when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(FIRST_PARAGRAPH_COMPONENT);
        when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(SECOND_PARAGRAPH_COMPONENT);

        //when
        Component actual = textParser.parse(TEXT_TO_PARSE);

        //then
        Assert.assertEquals(EXPECTED_COMPONENT, actual);

    }
}
