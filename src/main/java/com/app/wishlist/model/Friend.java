package com.app.wishlist.model;

public class Friend {

    private int id1;
    private int id2;

    public Friend() {

    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        if (id1 != friend.id1) return false;
        return id2 == friend.id2;

    }

    @Override
    public int hashCode() {
        int result = id1;
        result = 31 * result + id2;
        return result;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id1=" + id1 +
                ", id2=" + id2 +
                '}';
    }
}
