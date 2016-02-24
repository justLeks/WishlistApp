package com.app.wishlist.dao;

import com.app.wishlist.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FriendRepository implements FriendDao {

    private JdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new JdbcTemplate(jdbc);
    }

    public boolean add(Friend friend) {
        return jdbc.update("insert into public.friend (id1, id2) values (?, ?)",
                friend.getId1(), friend.getId2()) == 1;
    }

    public List<Integer> findById1(int id1) {
        return jdbc.query("select id2 from public.friend where id1 = ?",
                new Object[]{id1},
                new RowMapper<Integer>() {
                    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getInt("id2");
                    }
                });
    }

}
