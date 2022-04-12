package com.integration.integrationapp.models.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "localizations")
public class Location {

    private String locationName;
    private String street;
    private String city;
    private String postalCode;
}
