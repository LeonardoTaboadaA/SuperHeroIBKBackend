package com.app.superheroibk.entity;

import jakarta.persistence.*;

@Entity
//Table -> especifica el nombre de la tabla
@Table(name= "superhero_ability")
public class SuperheroAbility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "superhero_id")
    private Superhero superhero;

    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Ability ability;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Superhero getSuperhero() {
        return superhero;
    }

    public void setSuperhero(Superhero superhero) {
        this.superhero = superhero;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
