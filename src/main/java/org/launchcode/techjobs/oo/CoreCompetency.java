package org.launchcode.techjobs.oo;

public class CoreCompetency extends JobField {

    public CoreCompetency(String value) {
        super();
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
