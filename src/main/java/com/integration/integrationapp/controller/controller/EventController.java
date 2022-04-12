package com.integration.integrationapp.controller.controller;

import com.integration.integrationapp.models.entity.Category;
import com.integration.integrationapp.models.entity.Event;
import com.integration.integrationapp.models.enums.EventStatus;
import com.integration.integrationapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping(path = "api/v1/events")
@RestController
public class EventController {

    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping(path = "/upcoming")
    List<Event> getActiveEvents() {
        return eventRepository.findByStatus(EventStatus.ACTIVE);
    }

    @RequestMapping
    @GetMapping(path = "/upcoming")
    List<Event> getActiveEventsByCategory(@RequestBody CategoriesWrapper wrapper) {
        return eventRepository.findByStatus(EventStatus.ACTIVE).stream()
                .filter(event -> event.getCategories().contains(wrapper.categories.get(0)))
                .collect(Collectors.toList());
      //  return eventRepository.findByStatus(EventStatus.ACTIVE);
    }

    private static class CategoriesWrapper{
        List<Category> categories;
    }
}
