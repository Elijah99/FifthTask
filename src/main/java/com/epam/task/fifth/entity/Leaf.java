package com.epam.task.fifth.entity;

import java.util.Objects;

public class Leaf implements Component {

    private final LeafType type;
    private final String lexeme;

    public Leaf(LeafType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }

    public LeafType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Leaf)) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return lexeme.equals(leaf.lexeme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexeme);
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "lexeme='" + lexeme + '\'' +
                '}';
    }
}
