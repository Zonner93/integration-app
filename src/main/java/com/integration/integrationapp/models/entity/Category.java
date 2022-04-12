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
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String imageURL;

    @ManyToMany
    @JoinTable(
            name = "category_event",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> events;

    @ManyToMany(
            targetEntity = User.class,
            mappedBy = "categories",
            fetch = FetchType.LAZY)
    private Set<User> users;
}
