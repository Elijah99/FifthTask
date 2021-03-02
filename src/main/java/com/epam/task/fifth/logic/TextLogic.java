package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    public Composite sortParagraphsByNumberOfSentences(Composite text) {

        List<Component> paragraphs = text.getChildComponents();

        List<Component> paragraphsToSort = new ArrayList<>(paragraphs);

        paragraphsToSort.sort((first, second) -> {

            List<Component> firstChildren = ((Composite) first).getChildComponents();
            List<Component> secondChildren = ((Composite) second).getChildComponents();

            return firstChildren.size() - secondChildren.size();
        });

        return new Composite(paragraphsToSort);
    }

    public Composite sortWordsByLength(Composite sentence) {

        List<Component> lexemes = sentence.getChildComponents();

        List<Component> lexemesToSort = new ArrayList<>(lexemes);

        lexemesToSort.sort((first, second) -> {

            String firstLexeme = ((Leaf) first).getLexeme();
            String secondLexeme = ((Leaf) second).getLexeme();

            return firstLexeme.length() - secondLexeme.length();
        });

        return new Composite(lexemesToSort);
    }
}