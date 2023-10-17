package com.app.superheroibk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name= "superhero")
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private PowerLevel powerLevel;

    private boolean enabled = true;

    @OneToMany(mappedBy = "superhero", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<SuperheroAbility> superheroAbilities;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<SuperheroAbility> getSuperheroAbilities() {
        return superheroAbilities;
    }

    public void setSuperheroAbilities(Set<SuperheroAbility> superheroAbilities) {
        this.superheroAbilities = superheroAbilities;
    }
}
