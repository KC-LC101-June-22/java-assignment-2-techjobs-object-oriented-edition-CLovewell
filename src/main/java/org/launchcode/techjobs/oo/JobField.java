package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    String value;
    int id;

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
