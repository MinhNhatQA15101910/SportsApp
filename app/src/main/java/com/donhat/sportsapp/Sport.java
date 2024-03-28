package com.donhat.sportsapp;

public class Sport {
    private final int image;
    private final String name;

    public Sport(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
