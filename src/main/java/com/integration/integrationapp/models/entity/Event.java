package com.integration.integrationapp.models.entity;

import com.integration.integrationapp.models.enums.EventStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String eventName;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;

    @Embedded
    private Location location;

    @Enumerated
    private EventStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id")
    private User host;

    @ManyToMany(
            targetEntity = User.class,
            mappedBy = "participatesIn",
            fetch = FetchType.LAZY)
    private Set<User> participants;

    private String description;

    @ManyToMany(
            targetEntity = Badge.class,
            mappedBy = "events",
            fetch = FetchType.LAZY)
    private Set<Badge> rewards;

    @ManyToMany(
            targetEntity = Category.class,
            mappedBy = "events",
            fetch = FetchType.LAZY)
    private Set<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "event_event_tag",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "event_tag_id"))
    private Set<EventTag> tags;

}
