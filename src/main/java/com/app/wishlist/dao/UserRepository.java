package com.app.wishlist.dao;

import com.app.wishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository implements UserDao {

    private JdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new JdbcTemplate(jdbc);
    }

    public List<User> findAll() {
        return jdbc.query("select * from public.user", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEnabled(rs.getBoolean("enabled"));
                user.setAuthority(rs.getString("authority"));
                return user;
            }
        });
    }

    public User findByEmail(String email) {
        return jdbc.queryForObject("select * from public.user where email= ?",
                new Object[]{email},
                new BeanPropertyRowMapper<User>(User.class));
    }

    public User findById(int idUser) {
        return jdbc.queryForObject("select * from public.user where idUser= ?",
                new Object[]{idUser},
                new BeanPropertyRowMapper<User>(User.class));
    }

    public boolean add(User user) {
        return jdbc.update("insert into public.user (email, name, password, authority) values (?, ?, ?, ?)",
                user.getEmail(), user.getName(), user.getPassword(), "ROLE_USER") == 1;
    }

    public boolean update(User user) {
        return jdbc.update("update public.user set email = ?, name = ?, password = ?",
                user.getEmail(), user.getName(), user.getPassword()) == 1;
    }

    public boolean disableUser(String email) {
        return jdbc.update("update public.user set enabled = false where email = ?", email) == 1;
    }

    public User findByName(String name) {
        return jdbc.queryForObject("select * from public.user where name = ?",
                new Object[]{name},
                new BeanPropertyRowMapper<User>(User.class));
    }

    public User findByIdAndName(int idUser, String name) {
        return jdbc.queryForObject("select * from public.user where iduser = ? and name = ?",
                new Object[]{idUser, name},
                new BeanPropertyRowMapper<User>(User.class));
    }
}
