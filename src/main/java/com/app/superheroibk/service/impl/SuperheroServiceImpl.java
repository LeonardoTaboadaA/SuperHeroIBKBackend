package com.app.superheroibk.service.impl;

import com.app.superheroibk.entity.PowerLevel;
import com.app.superheroibk.entity.Superhero;
import com.app.superheroibk.exception.SuperheroNotFoundException;
import com.app.superheroibk.repository.SuperheroRepository;
import com.app.superheroibk.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroServiceImpl implements SuperheroService {

    @Autowired
    private SuperheroRepository superheroRepository;

    @Override
    public List<Superhero> findSuperHeroByName(String name) {

        List<Superhero> superheroListByName = superheroRepository.findByName(name);

        if (superheroListByName.isEmpty()){
            throw new SuperheroNotFoundException("Superhero with name '" + name + "' not found");
        }

        return superheroListByName;
    }

    @Override
    public List<Superhero> findSuperHeroByPowerLevel(PowerLevel powerLevel) {

        List<Superhero> superheroListByPowerLevel = superheroRepository.findByPowerLevel(powerLevel);

        if(superheroListByPowerLevel.isEmpty()){
            throw new SuperheroNotFoundException("Superhero not found list");
        }

        return superheroListByPowerLevel;
    }

    @Override
    public List<Superhero> findSuperHeroesByEnabledTrue() {

        List<Superhero> superheroListByEnabledTrue = superheroRepository.findByEnabledTrue();
        if(superheroListByEnabledTrue.isEmpty()){
            throw new SuperheroNotFoundException("Superhero not found list");
        }
        return superheroListByEnabledTrue;
    }

    @Override
    public Superhero getSuperHeroById(Long id) {
        Optional<Superhero> superheroById = superheroRepository.findById(id);
        if(superheroById.isPresent()){
            return superheroById.get();
        }
        else {
            throw new SuperheroNotFoundException("Superhero not found");
        }
    }

    @Override
    public Superhero createSuperhero(Superhero superhero) {

        return superheroRepository.save(superhero);

    }

    @Override
    public Superhero updateSuperhero(Superhero superhero) {
        return superheroRepository.save(superhero);
    }


}
