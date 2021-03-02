package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;

public class LexemeParserTest {

    public static final String WORD = "word";
    public static final Component EXPECTED_WORD = new Leaf(LeafType.WORD,"word");

    public static final String EXPRESSION = "[1 2 -]";
    public static final Component EXPECTED_EXPRESSION = new Leaf(LeafType.EXPRESSION,"[1 2 -]");

    @Test
    public void testParseShouldReturnLeafWordWhenInputTextIsWord(){
       //given
        Parser lexemeParser = new LexemeParser();
        //when
        Component actual = lexemeParser.parse(WORD);
        //then
        Assert.assertEquals(EXPECTED_WORD,actual);
    }

    @Test
    public void testParseShouldReturnLeafExpressionWhenInputTextIsExpression(){
        //given
        Parser lexemeParser = new LexemeParser();
        //when
        Component actual = lexemeParser.parse(EXPRESSION);
        //then
        Assert.assertEquals(EXPECTED_EXPRESSION,actual);
    }
}
