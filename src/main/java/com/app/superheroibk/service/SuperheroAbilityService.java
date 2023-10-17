package com.app.superheroibk.service;

import com.app.superheroibk.entity.Superhero;
import com.app.superheroibk.entity.SuperheroAbility;

public interface SuperheroAbilityService {
    public SuperheroAbility saveSuperheroAbility(SuperheroAbility superheroAbility);

    void deleteSuperheroAbilitiesBySuperheroId(Long superheroId);
}
