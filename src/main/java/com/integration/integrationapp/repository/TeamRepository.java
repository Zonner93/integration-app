package com.integration.integrationapp.repository;

import com.integration.integrationapp.models.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository  extends JpaRepository<Team, Long> {
}
