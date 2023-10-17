package com.app.superheroibk.repository;

import com.app.superheroibk.entity.Superhero;
import com.app.superheroibk.entity.SuperheroAbility;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroAbilityRepository extends JpaRepository<SuperheroAbility,Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM SuperheroAbility sa WHERE sa.superhero.id = :superheroId")
    void deleteAllBySuperheroId(Long superheroId);
}
