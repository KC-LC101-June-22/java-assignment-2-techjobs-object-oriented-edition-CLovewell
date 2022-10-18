package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Objects;

public abstract class JobField {
    public static final ArrayList<JobField> database = new ArrayList<>();
    static int nextId = 1;
    String value;
    int id;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) throws DuplicateJobFieldException {
        for (JobField jf : database) {
            if (jf.getValue().equals(value)) {
                throw new DuplicateJobFieldException("That job field already exists.");
            }
        }
        this.id = nextId;
        nextId++;
        this.value = value;
        database.add(this);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
