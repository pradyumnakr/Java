package com.example.jdbc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.jdbc.model.Alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AlienDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addAlien(Alien alien) {
        String sql = "insert into alien values(?,?,?)";
        jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getLanguage());

    }

    public List<Alien> getAllAliens() {
        String sql = "select * from alien";
        RowMapper<Alien> rowMapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien = new Alien();
                alien.setId(rs.getInt("id"));
                alien.setName(rs.getString("name"));
                alien.setLanguage(rs.getString("language"));
                return alien;
            }
        };

        List<Alien> aliens = jdbcTemplate.query(sql, rowMapper);
        return aliens;
    }

}
