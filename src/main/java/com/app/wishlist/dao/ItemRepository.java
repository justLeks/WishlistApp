package com.app.wishlist.dao;

import com.app.wishlist.model.Item;
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
public class ItemRepository implements ItemDao {

    private JdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new JdbcTemplate(jdbc);
    }

    public List<Item> findAll() {
        return jdbc.query("select * from public.item", new RowMapper<Item>() {
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                Item item = new Item();
                
                item.setIditem(rs.getInt("idItem"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getInt("price"));

                return item;
            }
        });
    }

    public Item findById(int idItem) {
        return jdbc.queryForObject("select * from public.item where iditem = ?",
                new Object[]{idItem},
                new BeanPropertyRowMapper<Item>(Item.class));
    }

    public Item findByName(String name) {
        return jdbc.queryForObject("select * from public.item where name = ?",
                new Object[]{name},
                new BeanPropertyRowMapper<Item>(Item.class));
    }

    public boolean add(Item item) {
        return jdbc.update("insert into public.item (name, description, price) values (?, ?, ?)",
                item.getName(), item.getDescription(), item.getPrice()) == 1;
    }

    public boolean update(Item item) {
        return jdbc.update("update public.item set name = ?, description = ?, price = ?",
                item.getName(), item.getDescription(), item.getPrice()) == 1;
    }
}
