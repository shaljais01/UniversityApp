package com.example.random;

public class Info2 {
    String rollno;
    String email;
    String name;
    String branch;
    String dsm;
    String adem;
    String oopsm;
    String dbmsm;
    String mm;

    Info2()
    {

    }

    public Info2(String rollno, String email, String name, String branch, String dsm, String adem, String oopsm, String dbmsm, String mm) {
        this.rollno = rollno;
        this.email = email;
        this.name = name;
        this.branch = branch;
        this.dsm = dsm;
        this.adem = adem;
        this.oopsm = oopsm;
        this.dbmsm = dbmsm;
        this.mm = mm;
    }

    public String getRollno() {
        return rollno;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getDsm() {
        return dsm;
    }

    public String getAdem() {
        return adem;
    }

    public String getOopsm() {
        return oopsm;
    }

    public String getDbmsm() {
        return dbmsm;
    }

    public String getMm() {
        return mm;
    }
}
