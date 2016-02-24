package com.app.wishlist.model;

public class Wish {

    private int idWish;
    private int idItem;
    private int idUser;
    private double finalPrice;

    public Wish() {
    }

    public int getIdWish() {
        return idWish;
    }

    public void setIdWish(int idWish) {
        this.idWish = idWish;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wish wish = (Wish) o;

        if (idWish != wish.idWish) return false;
        if (idItem != wish.idItem) return false;
        if (idUser != wish.idUser) return false;
        return Double.compare(wish.finalPrice, finalPrice) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idWish;
        result = 31 * result + idItem;
        result = 31 * result + idUser;
        temp = Double.doubleToLongBits(finalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "idWish=" + idWish +
                ", idItem=" + idItem +
                ", idUser=" + idUser +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
