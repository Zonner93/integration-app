package com.integration.integrationapp.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "eventTags")
public class EventTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(
            targetEntity = Event.class,
            mappedBy = "tags",
            fetch = FetchType.LAZY)
    private Set<Event>events;
}
