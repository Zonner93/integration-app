package com.integration.integrationapp.models.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "localizations")
public class Localization {

    private String name;
    private String street;
    private String city;
    private String postalCode;
}
