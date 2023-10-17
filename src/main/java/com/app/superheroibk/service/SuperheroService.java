package com.app.superheroibk.service;

import com.app.superheroibk.entity.PowerLevel;
import com.app.superheroibk.entity.Superhero;

import java.util.List;

public interface SuperheroService {
    public List<Superhero> findSuperHeroByName(String name) ;
    public List<Superhero> findSuperHeroByPowerLevel(PowerLevel powerLevel) ;
    public List<Superhero> findSuperHeroesByEnabledTrue() ;

    public Superhero getSuperHeroById(Long id);

    public Superhero createSuperhero(Superhero superhero);

    public Superhero updateSuperhero(Superhero superhero);
}
