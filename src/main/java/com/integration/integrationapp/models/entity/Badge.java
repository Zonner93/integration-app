package com.integration.integrationapp.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String imageURL;
    private int points;

    @ManyToMany
    @JoinTable(
            name = "badge_event",
            joinColumns = @JoinColumn(name = "badge_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> events;

    @ManyToMany(
            targetEntity = User.class,
            mappedBy = "badges",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<User> users;

}
