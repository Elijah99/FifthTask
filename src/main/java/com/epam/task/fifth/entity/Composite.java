package com.epam.task.fifth.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {

    private List<Component> childComponents = new ArrayList<Component>();

    public Composite(List<Component> childComponents) {
        this.childComponents = childComponents;
    }

    public List<Component> getChildComponents() {
        return childComponents;
    }

    public void addChildComponent(Component component) {
        childComponents.add(component);
    }

    public void removeChildComponent(Component component) {
        childComponents.remove(component);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return childComponents.equals(composite.childComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childComponents);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "childComponents=" + childComponents +
                '}';
    }
}
