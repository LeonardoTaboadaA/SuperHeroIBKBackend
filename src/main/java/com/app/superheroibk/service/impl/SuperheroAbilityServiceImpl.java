package com.app.superheroibk.service.impl;

import com.app.superheroibk.entity.Superhero;
import com.app.superheroibk.entity.SuperheroAbility;
import com.app.superheroibk.repository.SuperheroAbilityRepository;
import com.app.superheroibk.service.SuperheroAbilityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperheroAbilityServiceImpl implements SuperheroAbilityService {

    @Autowired
    private SuperheroAbilityRepository superheroAbilityRepository;
    @Override
    public SuperheroAbility saveSuperheroAbility(SuperheroAbility superheroAbility) {
        return superheroAbilityRepository.save(superheroAbility);
    }

    @Override
    @Transactional
    public void deleteSuperheroAbilitiesBySuperheroId(Long superheroId) {
        superheroAbilityRepository.deleteAllBySuperheroId(superheroId);
    }
}
