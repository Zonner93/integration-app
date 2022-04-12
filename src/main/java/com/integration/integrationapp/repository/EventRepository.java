package com.integration.integrationapp.repository;

import com.integration.integrationapp.models.entity.Event;
import com.integration.integrationapp.models.enums.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository  extends JpaRepository<Event, Long> {

    List<Event> findByStatus(EventStatus status);
}
