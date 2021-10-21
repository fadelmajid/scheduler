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
                SELECT * FROM event LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new EventRowMapper());
    }

    @Override
    public int insertEvent(Event event) {
        var sql = """
                INSERT INTO event(name, eventDate) 
                VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql, event.name(), event.eventDate());
    }

    @Override
    public int deleteEvent(int id) {
        var sql = """
                DELETE FROM movie
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Event> selectEventById(int id) {
        var sql = """
                SELECT id, name, eventDate
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
                SET name = ?, eventDate = ?, updatedDate = ?
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql,
                event.name(),
                event.eventDate(),
                LocalDate.now(),
                event.id());
    }
}
