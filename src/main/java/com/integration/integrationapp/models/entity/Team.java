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
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String image;

    @ManyToMany(
            targetEntity = User.class,
            mappedBy = "teams",
            fetch = FetchType.LAZY)
    private Set<User> users;
}
