package com.app.superheroibk.dto;

import com.app.superheroibk.entity.PowerLevel;

import java.util.List;

public class SuperheroWithAbilitiesRequest {
    private String name;
    private String description;
    private PowerLevel powerLevel;
    private List<Long> selectedAbilities;

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

    public List<Long> getSelectedAbilities() {
        return selectedAbilities;
    }

    public void setSelectedAbilities(List<Long> selectedAbilities) {
        this.selectedAbilities = selectedAbilities;
    }
}
