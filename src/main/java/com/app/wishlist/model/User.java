package com.app.wishlist.model;

public class User {

    private int idUser;
    private String email;
    private String name;
    private String password;
    private String authority;
    private boolean enabled;

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (enabled != user.enabled) return false;
        if (!email.equals(user.email)) return false;
        if (!name.equals(user.name)) return false;
        if (!password.equals(user.password)) return false;
        return authority.equals(user.authority);

    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + email.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + authority.hashCode();
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", authority='" + authority + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
