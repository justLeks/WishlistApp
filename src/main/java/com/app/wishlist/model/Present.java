package com.app.wishlist.model;

public class Present {

    private int idwish;
    private int iduser;

    public Present() {

    }

    public int getIdwish() {
        return idwish;
    }

    public void setIdwish(int idwish) {
        this.idwish = idwish;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Present present = (Present) o;

        if (idwish != present.idwish) return false;
        return iduser == present.iduser;

    }

    @Override
    public int hashCode() {
        int result = idwish;
        result = 31 * result + iduser;
        return result;
    }

    @Override
    public String toString() {
        return "Present{" +
                "idwish=" + idwish +
                ", iduser=" + iduser +
                '}';
    }
}
