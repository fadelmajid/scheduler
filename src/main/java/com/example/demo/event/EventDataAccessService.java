package com.example.demo.event;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class EventDataAccessService implements EventDAO {
    private final JdbcTemplate jdbcTemplate;

    public EventDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Event> selectEvent() {
        var sql = """
                SELECT e.id, e.name, e.event_date, e.created_date, e.updated_date FROM event e LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new EventRowMapper());
    }

    @Override
    public int insertEvent(Event event) {
        var sql = """
                INSERT INTO event(name, event_date) 
                VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql, event.name(), event.event_date());
    }

    @Override
    public int deleteEvent(int id) {
        var sql = """
                DELETE FROM event
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Event> selectEventById(int id) {
        var sql = """
                SELECT id, name, event_date
                FROM event
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new EventRowMapper(), id)
                .stream()
                .findFirst();

    }

    @Override
    public int updateEvent(Event event) {
        var sql = """
                UPDATE event
                SET name = ?, event_date = ?, updated_date = ?
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql,
                event.name(),
                event.event_date(),
                LocalDate.now(),
                event.id());
    }
}
