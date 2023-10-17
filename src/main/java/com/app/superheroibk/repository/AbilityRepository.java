package com.app.superheroibk.repository;


import com.app.superheroibk.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbilityRepository extends JpaRepository<Ability,Long> {
    Optional<Ability> findById(Long id);

    List<Ability> findByEnabledTrue();

}
