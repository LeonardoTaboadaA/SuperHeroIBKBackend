package com.app.superheroibk.service;

import com.app.superheroibk.entity.Ability;


import java.util.List;

public interface AbilityService {
    public Ability getAbilityById(Long id);
    public List<Ability> findAbilitiesByEnabledTrue() ;
}
