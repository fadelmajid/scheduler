package com.example.demo.event;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EventRowMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Event(
                rs.getInt("id"),
                rs.getString("name"),
                LocalDate.parse(rs.getString("eventDate")),                LocalDate.parse(rs.getString("eventDate")),
                LocalDate.parse(rs.getString("createdDate")),
                LocalDate.parse(rs.getString("updatedDate"))
                );
    }
}
