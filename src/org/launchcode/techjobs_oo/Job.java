package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        ++nextId;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString(){
        String jobString;
        if((name == null || name == "") && employer == null && location == null && positionType == null && coreCompetency == null){
            jobString = "\nOOPS! This job does not seem to exist.\n";
            return jobString;
        }
        jobString = '\n' + "ID: " + getId() + '\n' + "Name: ";
        if(getName() == null || getName() == ""){
            jobString += "Data not available" + "\nEmployer: ";
        } else{
            jobString += getName() + "\nEmployer: ";
        }
        if(getEmployer() == null || getEmployer().toString() == ""){
            jobString += "Data not available" + "\nLocation: ";
        } else{
            jobString += getEmployer().getValue() + "\nLocation: ";
        }
        if(getLocation() == null || getLocation().toString() == ""){
            jobString += "Data not available" + "\nPosition Type: ";
        } else{
            jobString += getLocation().getValue() + "\nPosition Type: ";
        }
        if(getPositionType() == null || getPositionType().toString() == ""){
            jobString += "Data not available" + "\nCore Competency: ";
        }else{
            jobString += getPositionType().getValue() + "\nCore Competency: ";
        }
        if(getCoreCompetency() == null || getCoreCompetency().toString() == ""){
            jobString += "Data not available\n";
        }else{
            jobString += getCoreCompetency().getValue() + "\n";
        }
        return jobString;
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

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
