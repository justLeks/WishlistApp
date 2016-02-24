package com.app.wishlist.dao;

import com.app.wishlist.model.Wish;
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
public class WishRepository implements WishDao {

    private JdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new JdbcTemplate(jdbc);
    }

    public List<Wish> findAll() {
        return jdbc.query("select * from public.wish", new RowMapper<Wish>() {
            public Wish mapRow(ResultSet rs, int rowNum) throws SQLException {
                Wish wish = new Wish();

                wish.setIdWish(rs.getInt("idwish"));
                wish.setIdItem(rs.getInt("iditem"));
                wish.setIdUser(rs.getInt("iduser"));
                wish.setFinalPrice(rs.getDouble("finalprice"));

                return wish;
            }
        });
    }

    public List<Wish> findByUserId(int idUser) {
        return jdbc.query("select * from public.wish where iduser = ?",
                new Object[] {idUser},
                new RowMapper<Wish>() {
            public Wish mapRow(ResultSet rs, int rowNum) throws SQLException {
                Wish wish = new Wish();

                wish.setIdWish(rs.getInt("idwish"));
                wish.setIdItem(rs.getInt("iditem"));
                wish.setIdUser(rs.getInt("iduser"));
                wish.setFinalPrice(rs.getDouble("finalprice"));

                return wish;
            }
        });
    }

    public Wish findByWishId(int idWish) {
        return jdbc.queryForObject("select * from public.wish where idwish = ?",
                new Object[]{idWish},
                new BeanPropertyRowMapper<Wish>(Wish.class));
    }

    public boolean add(Wish wish) {
        return jdbc.update("insert into public.wish(iditem, iduser, finalprice) values (?, ?, ?)",
                wish.getIdItem(), wish.getIdUser(), wish.getFinalPrice()) == 1;
    }

    public boolean update(Wish wish) {
        return jdbc.update("update public.wish set finalprice = ? where idwish = ?",
                wish.getFinalPrice(), wish.getIdWish()) == 1;
    }
}
