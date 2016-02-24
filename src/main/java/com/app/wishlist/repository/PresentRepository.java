package com.app.wishlist.repository;

import com.app.wishlist.dao.PresentDao;
import com.app.wishlist.model.Present;
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
public class PresentRepository implements PresentDao {

    private JdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new JdbcTemplate(jdbc);
    }

    public List<Present> findAll() {
        return jdbc.query("select * from public.present", new RowMapper<Present>() {
            public Present mapRow(ResultSet rs, int rowNum) throws SQLException {
                Present present = new Present();

                present.setIdwish(rs.getInt("idwish"));
                present.setIduser(rs.getInt("iduser"));

                return present;
            }
        });
    }

    public List<Present> findByWishId(int idwish) {
        return jdbc.query("select * from public.present where idwish = ?",
                new Object[]{idwish},
                new RowMapper<Present>() {
                    public Present mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Present present = new Present();

                        present.setIduser(rs.getInt("iduser"));
                        present.setIdwish(rs.getInt("idwish"));

                        return present;
                    }
                });
    }

    public List<Present> findByUserId(int iduser) {
        return jdbc.query("select * from public.present where iduser = ?",
                new Object[]{iduser},
                new RowMapper<Present>() {
                    public Present mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Present present = new Present();

                        present.setIduser(rs.getInt("iduser"));
                        present.setIdwish(rs.getInt("idwish"));

                        return present;
                    }
                });
    }

    public Present findByWishIdAndUserId(int idWish, int idUser) {
        return jdbc.queryForObject("select * from public.present where idwish = ? and iduser = ?",
                new Object[]{idWish, idUser},
                new BeanPropertyRowMapper<Present>(Present.class));
    }

    public boolean add(Present present) {
        return jdbc.update("insert into public.present (idwish, iduser) values (?, ?)",
                present.getIdwish(), present.getIduser()) == 1;
    }

    public boolean delete(int idWish, int idUser) {
        return jdbc.update("delete from public.present where idwish = ? and iduser = ?",
                idWish, idUser) == 1;
    }
}
