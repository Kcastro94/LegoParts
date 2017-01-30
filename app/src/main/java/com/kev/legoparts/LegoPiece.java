package com.kev.legoparts;

/**
 * Created by DAM on 23/1/17.
 */

public class LegoPiece {
    private long setId;
    private long pieceId;
    private String name;
    private int image;
    private int quantity;

    public LegoPiece(){}

    public LegoPiece(long setId, long pieceId, String name, int image, int quantity) {
        this.setId = setId;
        this.pieceId = pieceId;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
    }

    public long getSetId() {
        return setId;
    }

    public void setSetId(long setId) {
        this.setId = setId;
    }

    public long getPieceId() {
        return pieceId;
    }

    public void setPieceId(long pieceId) {
        this.pieceId = pieceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
