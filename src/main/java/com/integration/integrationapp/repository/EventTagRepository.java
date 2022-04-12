package com.integration.integrationapp.repository;

import com.integration.integrationapp.models.entity.EventTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTagRepository  extends JpaRepository<EventTag, Long> {
}
