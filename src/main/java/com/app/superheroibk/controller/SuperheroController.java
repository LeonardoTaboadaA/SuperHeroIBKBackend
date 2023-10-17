package com.app.superheroibk.controller;

import com.app.superheroibk.dto.SuperheroWithAbilitiesRequest;
import com.app.superheroibk.dto.SuperheroWithAbilitiesResponse;
import com.app.superheroibk.entity.Ability;
import com.app.superheroibk.entity.PowerLevel;
import com.app.superheroibk.entity.Superhero;
import com.app.superheroibk.entity.SuperheroAbility;
import com.app.superheroibk.service.AbilityService;
import com.app.superheroibk.service.SuperheroAbilityService;
import com.app.superheroibk.service.SuperheroService;
import com.app.superheroibk.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/superheroes")
@CrossOrigin("*")
public class SuperheroController {
    @Autowired
    private SuperheroService superheroService;

    @Autowired
    private AbilityService abilityService;

    @Autowired
    private SuperheroAbilityService superheroAbilityService;
/*
    @GetMapping("")
    public ResponseEntity<List<Superhero>> getAllEnabledSuperheroes() {
        List<Superhero> superheroesList = superheroService.findSuperHeroesByEnabledTrue();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }*/

    @GetMapping("")
    public ResponseEntity<List<SuperheroWithAbilitiesResponse>> getAllEnabledSuperheroesWithAbilities() {
        List<Superhero> superheroesList = superheroService.findSuperHeroesByEnabledTrue();
        List<SuperheroWithAbilitiesResponse> responseList = new ArrayList<>();

        for (Superhero superhero : superheroesList) {
            Set<SuperheroAbility> superheroAbilities = superhero.getSuperheroAbilities();
            List<Ability> abilities = superheroAbilities.stream()
                    .map(SuperheroAbility::getAbility)
                    .collect(Collectors.toList());

            SuperheroWithAbilitiesResponse response = new SuperheroWithAbilitiesResponse();
            response.setId(superhero.getId());
            response.setName(superhero.getName());
            response.setDescription(superhero.getDescription());
            response.setPowerLevel(superhero.getPowerLevel());
            response.setAbilities(abilities);

            responseList.add(response);
        }

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<List<Superhero>> getSuperHeroesByName(@PathVariable("name") String name) {
        List<Superhero> superheroesList = superheroService.findSuperHeroByName(name);
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }

    @GetMapping("/nivel-de-poder/{powerLevel}")
    public ResponseEntity<List<Superhero>> getSuperHeroesByPowerLevel(@PathVariable("powerLevel") PowerLevel powerLevel) {
        List<Superhero> superheroesList = superheroService.findSuperHeroByPowerLevel(powerLevel);
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse> createSuperhero(@RequestBody SuperheroWithAbilitiesRequest request) {

        // Crear el superhéroe
        Superhero superhero = new Superhero();
        superhero.setName(request.getName());
        superhero.setDescription(request.getDescription());
        superhero.setPowerLevel(request.getPowerLevel());

        // Guardar el superhéroe en la base de datos
        Superhero savedSuperhero = superheroService.createSuperhero(superhero);

        // Asignar habilidades al superhéroe
        for (Long abilityId : request.getSelectedAbilities()) {
            Ability ability = abilityService.getAbilityById(abilityId);
            if (ability != null) {
                SuperheroAbility superheroAbility = new SuperheroAbility();
                superheroAbility.setSuperhero(savedSuperhero);
                superheroAbility.setAbility(ability);
                superheroAbilityService.saveSuperheroAbility(superheroAbility);
            }
        }
        ApiResponse response = new ApiResponse("Superhéroe creado exitosamente");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ApiResponse> updateSuperhero(@PathVariable Long id, @RequestBody SuperheroWithAbilitiesRequest request) {
        try {
            // Buscar el superhéroe existente por su ID
            Superhero superhero = superheroService.getSuperHeroById(id);

            if (superhero == null) {
                ApiResponse response = new ApiResponse("Superhéroe no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            // Actualizar los atributos del superhéroe con los datos de la solicitud
            superhero.setName(request.getName());
            superhero.setDescription(request.getDescription());
            superhero.setPowerLevel(request.getPowerLevel());

            superheroAbilityService.deleteSuperheroAbilitiesBySuperheroId(superhero.getId());

            // Asignar las nuevas habilidades seleccionadas en la solicitud
            for (Long abilityId : request.getSelectedAbilities()) {
                Ability ability = abilityService.getAbilityById(abilityId);
                if (ability != null) {
                    SuperheroAbility superheroAbility = new SuperheroAbility();
                    superheroAbility.setSuperhero(superhero);
                    superheroAbility.setAbility(ability);
                    superheroAbilityService.saveSuperheroAbility(superheroAbility);
                }
            }

            // Actualizar el superhéroe en la base de datos
            superheroService.updateSuperhero(superhero);

            ApiResponse response = new ApiResponse("Superhéroe actualizado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("Error al actualizar el superhéroe: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<ApiResponse> deleteSuperhero(@PathVariable Long id) {
        try {
            // Buscar el superhéroe existente por su ID
            Superhero superhero = superheroService.getSuperHeroById(id);

            if (superhero == null) {
                ApiResponse response = new ApiResponse("Superhéroe no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            // Cambiar el estado 'enabled' a false
            superhero.setEnabled(false);

            // Actualizar el superhéroe en la base de datos
            superheroService.updateSuperhero(superhero);

            ApiResponse response = new ApiResponse("Superhéroe eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("Error al eliminar el superhéroe: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
