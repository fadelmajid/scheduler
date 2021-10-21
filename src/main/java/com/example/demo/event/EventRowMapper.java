package com.example.demo.event;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println(rs);
        return new Event(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDate("event_date"),
                rs.getDate("created_date"),
                rs.getDate("updated_date")
        );
    }
}
