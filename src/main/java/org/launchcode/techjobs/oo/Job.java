package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = Job.nextId;
        Job.nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String name = (this.getName() == null || this.getName().equals("") ?
                "Data not available" : this.getName());
        String employer = (this.getEmployer() == null || this.getEmployer().getValue().equals("") ?
                "Data not available" : this.getEmployer().getValue());;
        String location = (this.getLocation() == null || this.getLocation().getValue().equals("") ?
                "Data not available" : this.getLocation().getValue());;
        String positionType = (this.getPositionType() == null || this.getPositionType().getValue().equals("") ?
                "Data not available" : this.getPositionType().getValue());;
        String coreCompetency = (this.getCoreCompetency() == null || this.getCoreCompetency().getValue().equals("") ?
                "Data not available" : this.getCoreCompetency().getValue());;

        return  ((this.getName()==null || this.getName().equals(""))
                && (this.getEmployer()==null || this.getEmployer().getValue().equals(""))
                && (this.getLocation()==null || this.getLocation().getValue().equals(""))
                && (this.getPositionType()==null || this.getPositionType().getValue().equals(""))
                && (this.getCoreCompetency()==null || this.getCoreCompetency().getValue().equals("")) ?
                "OOPS! This job does not seem to exist." :
                "\nID: " + this.getId() +
                "\nName: " + name +
                "\nEmployer: " + employer +
                "\nLocation: " + location +
                "\nPosition Type: " + positionType +
                "\nCore Competency: " + coreCompetency + '\n');
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
