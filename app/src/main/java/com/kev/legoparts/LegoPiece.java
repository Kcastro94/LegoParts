package com.kev.legoparts;

/**
 * Created by DAM on 23/1/17.
 */

public class LegoPiece {
    private long id;
    private String name;
    private String image;
    private int quantity;

    public LegoPiece(long id, int quantity, String image, String name) {
        this.id = id;
        this.quantity = quantity;
        this.image = image;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LegoPiece legoPiece = (LegoPiece) o;

        if (id != legoPiece.id) return false;
        return name != null ? name.equals(legoPiece.name) : legoPiece.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
