package com.example.demo.event;


import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventDAO eventDAO;

    public EventService(EventDAO eventDAO){
        this.eventDAO = eventDAO;
    }

    public void addEvent(Event event){
        int result = eventDAO.insertEvent(event);
        if(result != 1){
            throw new IllegalStateException("Oops something went wrong");
        }
    }

    public List<Event> getEvents(){
        return eventDAO.selectEvent();
    }

    public Event getEvent(int id) {
        return eventDAO.selectEventById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Movie with id %s not found", id)));
    }

    public void deleteEvent(Integer id) {
        Optional<Event> events = eventDAO.selectEventById(id);
        events.ifPresentOrElse(movie -> {
            int result = eventDAO.deleteEvent(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete movie");
            }
        }, () -> {
            throw new NotFoundException(String.format("Movie with id %s not found", id));
        });
    }
}
