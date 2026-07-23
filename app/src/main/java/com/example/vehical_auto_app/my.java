package com.example.vehical_auto_app;

public class my {
    String garegename,number,address,service,type,lati,longi,imageurl;


    public my() {
    }

    public my(String garegename, String number, String address, String service, String type, String lati, String longi, String imageurl) {
        this.garegename = garegename;
        this.number = number;
        this.address = address;
        this.service = service;
        this.type = type;
        this.lati = lati;
        this.longi = longi;
        this.imageurl = imageurl;
    }

    public String getGaregename() {
        return garegename;
    }

    public void setGaregename(String garegename) {
        this.garegename = garegename;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
