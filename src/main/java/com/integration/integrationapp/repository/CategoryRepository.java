package com.integration.integrationapp.repository;

import com.integration.integrationapp.models.entity.Badge;
import com.integration.integrationapp.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
