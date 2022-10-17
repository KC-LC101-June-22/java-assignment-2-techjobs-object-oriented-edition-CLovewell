package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    static int nextId = 1;
    String value;
    int id;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
