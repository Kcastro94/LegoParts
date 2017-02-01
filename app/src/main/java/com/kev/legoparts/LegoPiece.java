package com.kev.legoparts;

import android.net.Uri;

import java.net.URL;

/**
 * Created by DAM on 23/1/17.
 */

public class LegoPiece {
    private long id;
    private String name;
    private Uri image;
    private int quantity;

    public LegoPiece(){}

    public LegoPiece(long id, String name, Uri image, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
