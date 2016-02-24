package com.app.wishlist.dao;

import com.app.wishlist.model.Present;
import org.springframework.beans.factory.annotation.Autowired;
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

    public boolean add(Present present) {
        return jdbc.update("insert into public.present (idwish, iduser) values (?, ?)",
                present.getIdwish(), present.getIduser()) == 1;
    }
}
