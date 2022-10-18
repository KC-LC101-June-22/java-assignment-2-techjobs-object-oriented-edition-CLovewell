package org.launchcode.techjobs.oo;

public class PositionType extends JobField{

    public PositionType(String value) throws DuplicateJobFieldException {
        super(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionType that = (PositionType) o;
        return id == that.id;
    }
}
