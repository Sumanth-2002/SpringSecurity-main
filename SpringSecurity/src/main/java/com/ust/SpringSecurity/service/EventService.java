package com.ust.SpringSecurity.service;

import com.ust.SpringSecurity.model.Event;
import com.ust.SpringSecurity.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repo;
    public Event addEvent(Event event) {
        return repo.save(event);
    }

    public List<Event> getAllEvents() {
        return repo.findAll();
    }
}
