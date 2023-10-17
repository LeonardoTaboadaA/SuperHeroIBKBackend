package com.app.superheroibk.controller;

import com.app.superheroibk.entity.Ability;
import com.app.superheroibk.entity.Superhero;
import com.app.superheroibk.service.AbilityService;
import com.app.superheroibk.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
@CrossOrigin("*")
public class AbilityController {
    @Autowired
    private AbilityService abilityService;

    @GetMapping("")
    public ResponseEntity<List<Ability>> getAllEnabledAbilities() {
        List<Ability> abilitiesList = abilityService.findAbilitiesByEnabledTrue();
        return new ResponseEntity<>(abilitiesList, HttpStatus.OK);
    }
}
