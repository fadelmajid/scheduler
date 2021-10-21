package com.example.demo.event;

import java.util.List;
import java.util.Optional;

public interface EventDAO {
    List<Event> selectEvent();
    int insertEvent(Event event);
    int deleteEvent(int id);
    Optional<Event> selectEventById(int id);
    int updateEvent(Event event);
}
