package com.integration.integrationapp.repository;

import com.integration.integrationapp.models.entity.*;
import com.integration.integrationapp.models.enums.EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class DbMockData {

    private final String password = "sportelo";

    private final BadgeRepository badgeRepository;
    private final CategoryRepository categoryRepository;
    private final EventRepository eventRepository;
    private final EventTagRepository eventTagRepository;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    @Autowired

    public DbMockData(BadgeRepository badgeRepository, CategoryRepository categoryRepository, EventRepository eventRepository, EventTagRepository eventTagRepository, TeamRepository teamRepository, UserRepository userRepository) {
        this.badgeRepository = badgeRepository;
        this.categoryRepository = categoryRepository;
        this.eventRepository = eventRepository;
        this.eventTagRepository = eventTagRepository;
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill(){
        addBadges();
        addCategories();
        addEventTags();
        addUsers();
        addEvents();
    }

    public void addBadges(){
        badgeRepository.save(
                Badge.builder()
                        .name("Leci Czorny Diobeł")
                        .imageURL("https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX25382499.jpg")
                        .points(200)
                        .build()
        );
        badgeRepository.save(
                Badge.builder()
                        .name("darth vader")
                        .imageURL("https://www.shareicon.net/data/512x512/2016/11/21/854776_darth_512x512.png")
                        .points(100)
                        .build()
        );
    }

    private void addCategories() {
        categoryRepository.save(
                Category.builder()
                        .name("Hackaton")
                        .imageURL("https://d29fhpw069ctt2.cloudfront.net/icon/image/84560/preview.svg")
                        .build()
        );
        categoryRepository.save(
                Category.builder()
                        .name("Bilard")
                        .imageURL("https://cdn-icons-png.flaticon.com/512/147/147202.png")
                        .build()
        );
        categoryRepository.save(
                Category.builder()
                        .name("Jedzenie")
                        .imageURL("https://cdn-icons-png.flaticon.com/512/104/104986.png")
                        .build()
        );
        categoryRepository.save(
                Category.builder()
                        .name("Tenis")
                        .imageURL("https://cdn-icons-png.flaticon.com/512/2855/2855453.png")
                        .build()
        );
    }

    private void addEventTags() {
    }

    public void addUsers(){
        userRepository.save(
                User.builder()
                        .name("Kuba Mistrz")
                        .email("kuba@gmail.com")
                        .password(password)
                        .build()
        );
        userRepository.save(
                User.builder()
                        .name("Grzegorz Szef")
                        .email("grzegorz@gmail.com")
                        .password(password)
                        .badges(new HashSet<>(
                                badgeRepository.findAll()
                        ))
                        .build()
        );
    }

    public void addEvents(){
        eventRepository.save(
                Event.builder()
                        .eventName("Bilard Rewanżyk")
                        .dateStart(LocalDateTime.now())
                        .location(Location.builder()
                                .locationName("Bilardowo")
                                .city("Warszawa")
                                .street("Piękna 9")
                                .build())
                        .status(EventStatus.ACTIVE)
                        //.host(userRepository.getById(1L))
                        .description("Turniej bilardowy z prawdziwego zdarzenia. Zapraszam każdego - przewidziane nagrody.")
                        //.categories(new HashSet<Category>(List.of(new Category[]{categoryRepository.findById(3L).get()})))
                        .build()

        );
        eventRepository.save(
                Event.builder()
                        .eventName("Jedzenie Ostrych Sosów")
                        .dateStart(LocalDateTime.now())
                        .location(Location.builder()
                                .locationName("Kuchnia")
                                .city("Warszawa")
                                .street("Cybernetyki 9")
                                .build())
                        .status(EventStatus.ACTIVE)
                        .description("Turniej jedzenia ostrych sosów. Zapraszam każdego - przewidziane nagrody.")
                        .rewards(
                                new HashSet<>(
                                        badgeRepository.findAll()
                                )
                        )
                        .build()

        );
    }
}
