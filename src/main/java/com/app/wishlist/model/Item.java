package com.app.wishlist.model;

public class Item {

    private int iditem;
    private String name;
    private String description;
    private double price;

    public Item() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (iditem != item.iditem) return false;
        if (Double.compare(item.price, price) != 0) return false;
        if (!name.equals(item.name)) return false;
        return description.equals(item.description);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iditem;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "iditem=" + iditem +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
