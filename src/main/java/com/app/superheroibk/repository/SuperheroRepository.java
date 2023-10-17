package com.app.superheroibk.repository;

import com.app.superheroibk.entity.PowerLevel;
import com.app.superheroibk.entity.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero,Long> {
    @Query("SELECT s FROM Superhero s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Superhero> findByName(@Param("name") String name);

    @Query("SELECT s FROM Superhero s WHERE s.powerLevel = :powerLevel")
    List<Superhero> findByPowerLevel(@Param("powerLevel") PowerLevel powerLevel);

    List<Superhero> findByEnabledTrue();

    //Optional<Superhero> -> para manejar el caso en el que no se encuentra un superhéroe con el ID especificado
    Optional<Superhero> findById(Long id);


}
