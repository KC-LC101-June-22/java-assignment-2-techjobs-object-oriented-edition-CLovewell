package org.launchcode.techjobs.oo;

public class Location extends JobField {
    private static int nextId = 1;

    public Location() {
        id = nextId;
        nextId++;
    }

    public Location(String value) {
        this();
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId() == location.getId();
    }
}
