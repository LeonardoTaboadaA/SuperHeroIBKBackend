package com.app.superheroibk.dto;

import com.app.superheroibk.entity.Ability;
import com.app.superheroibk.entity.PowerLevel;

import java.util.List;

public class SuperheroWithAbilitiesResponse {
    private Long id;
    private String name;
    private String description;
    private PowerLevel powerLevel;
    private List<Ability> abilities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PowerLevel getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(PowerLevel powerLevel) {
        this.powerLevel = powerLevel;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
