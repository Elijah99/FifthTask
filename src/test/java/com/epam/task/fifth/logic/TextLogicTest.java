package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextLogicTest {

    public static final Component FIRST_PARAGRAPH = new Composite(
            Arrays.asList(
                    new Composite(
                            Arrays.asList(
                                    new Leaf(LeafType.WORD, "First"),
                                    new Leaf(LeafType.WORD, "Sentence")
                            )
                    ),
                    new Composite(
                            Collections.singletonList(
                                    new Leaf(LeafType.WORD, "Second")
                            )
                    )
            )
    );

    private static final Component SECOND_PARAGRAPH = new Composite(
            Collections.singletonList(
                    new Composite(
                            Arrays.asList(
                                    new Leaf(LeafType.WORD, "First"),
                                    new Leaf(LeafType.WORD, "Sentence")
                            )
                    )
            )
    );
    private final static Composite UNSORTED_PARAGRAPHS = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH));


    private static final Composite EXPECTED_SORTED_PARAGRAPHS = new Composite(Arrays.asList(SECOND_PARAGRAPH, FIRST_PARAGRAPH));

    private final static Component FIRST_LEXEME = new Leaf(LeafType.WORD, "ashf");
    private final static Component SECOND_LEXEME = new Leaf(LeafType.WORD, "A");
    private final static Component THIRD_LEXEME = new Leaf(LeafType.WORD, "Ab1");

    private final static Composite UNSORTED_LEXEMES = new Composite(Arrays.asList(FIRST_LEXEME, SECOND_LEXEME,THIRD_LEXEME));
    private final static Composite EXPECTED_SORTED_LEXEMES = new Composite(Arrays.asList(SECOND_LEXEME, THIRD_LEXEME,FIRST_LEXEME));


    @Test
    public void testSortParagraphsByNumberOfSentences() {
        //given
        TextLogic textLogic = new TextLogic();

        //when
        Composite actual = textLogic.sortParagraphsByNumberOfSentences(UNSORTED_PARAGRAPHS);

        //then
        Assert.assertEquals(EXPECTED_SORTED_PARAGRAPHS, actual);
    }

    @Test
    public void testSortWordsByLength() {
        //given
        TextLogic textLogic = new TextLogic();

        //when
        Composite actual = textLogic.sortWordsByLength(UNSORTED_LEXEMES);

        //then
        Assert.assertEquals(EXPECTED_SORTED_LEXEMES, actual);
    }
}
