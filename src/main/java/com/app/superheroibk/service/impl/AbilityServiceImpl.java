package com.app.superheroibk.service.impl;

import com.app.superheroibk.entity.Ability;
import com.app.superheroibk.exception.AbilityNotFoundException;
import com.app.superheroibk.exception.SuperheroNotFoundException;
import com.app.superheroibk.repository.AbilityRepository;

import com.app.superheroibk.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbilityServiceImpl implements AbilityService {
    @Autowired
    private AbilityRepository abilityRepository;


    @Override
    public Ability getAbilityById(Long id) {
        Optional<Ability> abilityById = abilityRepository.findById(id);
        if(abilityById.isPresent()){
            return abilityById.get();
        }
        else {
            throw new AbilityNotFoundException("Ability not found");
        }
    }

    @Override
    public List<Ability> findAbilitiesByEnabledTrue() {
        List<Ability> abilitiesListByEnabledTrue = abilityRepository.findByEnabledTrue();
        if(abilitiesListByEnabledTrue.isEmpty()){
            throw new AbilityNotFoundException("Ability not found list");
        }
        return abilitiesListByEnabledTrue;
    }
}
