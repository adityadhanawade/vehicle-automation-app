package com.example.vehical_auto_app;

public class Feedback {

    String gname,name,feedback,rating;

    public Feedback() {
    }

    public Feedback(String gname, String name, String feedback, String rating) {
        this.gname = gname;
        this.name = name;
        this.feedback = feedback;
        this.rating = rating;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
