package com.example.vehical_auto_app;

public class Userprofile {

    String name,number,address,Carno,imageurl;

    public Userprofile() {
    }

    public Userprofile(String name, String number, String address, String carno, String imageurl) {
        this.name = name;
        this.number = number;
        this.address = address;
        Carno = carno;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarno() {
        return Carno;
    }

    public void setCarno(String carno) {
        Carno = carno;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
