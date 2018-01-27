package com.example.recyclerview;

/**
 * Created by liyiwei on 2018/1/25.
 */

public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return this.name;
    }

    public int getImageId() {
        return this.imageId;
    }
}
