package org.launchcode.techjobs.oo;

public class CoreCompetency extends JobField {
    private static int nextId = 1;

    public CoreCompetency() {
        this.id = nextId;
        nextId++;
    }

    public CoreCompetency(String value) {
        this();
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoreCompetency)) return false;
        CoreCompetency that = (CoreCompetency) o;
        return id == that.id;
    }
}
