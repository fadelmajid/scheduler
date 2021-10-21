package com.example.demo.event;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> listEvents(){
        return eventService.getEvents();
    }


    @GetMapping("{id}")
    public Event getEventById(@PathVariable("id") Integer id){
        return eventService.getEvent(id);
    }

    @PostMapping
    public void addEvent(@RequestBody Event event){
        eventService.addEvent(event);
    }

    @DeleteMapping("{id}")
    public void deleteEvent(@PathVariable("id") Integer id){
        eventService.deleteEvent(id);
    }


    // TODO - to update
    @PatchMapping
    public void updateEvent(@RequestBody Event event){
        throw new IllegalStateException("test");
    }
}
