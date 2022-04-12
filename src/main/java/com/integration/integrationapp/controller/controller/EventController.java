package com.integration.integrationapp.controller.controller;

import com.integration.integrationapp.models.dto.EventDto;
import com.integration.integrationapp.models.entity.Category;
import com.integration.integrationapp.models.entity.Event;
import com.integration.integrationapp.models.enums.EventStatus;
import com.integration.integrationapp.models.mapper.EventMapper;
import com.integration.integrationapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping(path = "api/v1/events")
@RestController
public class EventController {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;


    @Autowired
    public EventController(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @GetMapping(path = "/upcoming")
    List<EventDto> getActiveEvents() {
        return eventRepository
                .findByStatus(EventStatus.ACTIVE)
                .stream().map(
                        eventMapper::entityToDto
                ).collect(Collectors.toList());
    }

    @PostMapping(path = "/")
    ResponseEntity<?> addNewEvent(@RequestBody EventDto eventDto) {

        if (eventDto != null)
            return new ResponseEntity<>(
                    eventRepository.save(eventMapper.dtoToEntity(eventDto)),
                    HttpStatus.OK
            );

        return new ResponseEntity<>(
                "Not Found", HttpStatus.NOT_FOUND
        );
    }


    @GetMapping(path = "/")
    ResponseEntity<?> eventFinder(@RequestParam Long id) {

        Optional<Event> result = eventRepository.findById(id);

        if (result.isPresent())
            return new ResponseEntity<>(
                    eventMapper.entityToDto(result.get()), HttpStatus.OK
            );

        return new ResponseEntity<>(
                "Not Found", HttpStatus.NOT_FOUND
        );
    }

    @RequestMapping
    @GetMapping(path = "/upcoming")
    List<EventDto> getActiveEventsByCategory(@RequestBody CategoriesWrapper wrapper) {
        return eventRepository.findByStatus(EventStatus.ACTIVE).stream()
                .filter(event -> {
                            return event.getCategories()
                                    .stream()
                                    .anyMatch(category -> wrapper.categories.contains(category));
                        }
                ).map(eventMapper::entityToDto)
                .collect(Collectors.toList());
    }

    private static class CategoriesWrapper {
        List<Category> categories;
    }
}
