package com.example.vehical_auto_app;

public class User {

    String type,problem,modelno,username,number,imageurl,gname,gaddress,gnumber;

    public User() {
    }

    public User(String type, String problem, String modelno, String username, String number, String imageurl, String gname, String gaddress, String gnumber) {
        this.type = type;
        this.problem = problem;
        this.modelno = modelno;
        this.username = username;
        this.number = number;
        this.imageurl = imageurl;
        this.gname = gname;
        this.gaddress = gaddress;
        this.gnumber = gnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGaddress() {
        return gaddress;
    }

    public void setGaddress(String gaddress) {
        this.gaddress = gaddress;
    }

    public String getGnumber() {
        return gnumber;
    }

    public void setGnumber(String gnumber) {
        this.gnumber = gnumber;
    }
}
