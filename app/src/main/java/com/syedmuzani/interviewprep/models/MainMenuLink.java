package com.syedmuzani.interviewprep.models;

/**
 * Manages things in the main menu
 * Created by muz on 2017-11-13.
 */

public class MainMenuLink {
    public String title = "";
    public Class activityClass;

    public MainMenuLink(String title, Class activity) {
        this.title = title;
        this.activityClass = activity;
    }
}
