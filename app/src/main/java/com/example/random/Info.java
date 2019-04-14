package com.example.random;

public class Info {
    String rollno;
    String emailaddress;
    String name;
    String branch;
    String p;
    String rollno2;

    public Info(){

    }

    public Info(String rollno, String emailaddress, String name, String branch,String p,String rollno2) {
        this.rollno = rollno;
        this.emailaddress = emailaddress;
        this.name = name;
        this.branch = branch;
        this.p=p;
        this.rollno2=rollno2;
    }

    public String getRollno() {
        return rollno;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }
    public String getP() {
        return p;
    }
    public String getRollno2(){return  rollno2;}
}
