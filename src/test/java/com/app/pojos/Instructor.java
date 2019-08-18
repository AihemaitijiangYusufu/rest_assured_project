package com.app.pojos;

public class Instructor {

    private String firstName;
    private String lastName;
    private String subject;
    private int batch;
    private int id;

    @Override
    public String toString() {
        return "Instructor{"+
                "firstName='"+firstName+'\''+
                ", lastName='"+lastName+'\''+
                ", subject='"+subject+'\''+
                ", batch='"+batch+'\''+
                ", id='"+id+'\''+
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
