package com.example.Api_Rest_JAVA_SpringBoot.controller;


import com.example.Api_Rest_JAVA_SpringBoot.dto.common.Response;
import com.example.Api_Rest_JAVA_SpringBoot.dto.planetDto.PlanetRequestDto;
import com.example.Api_Rest_JAVA_SpringBoot.dto.planetDto.PlanetResponseDto;
import com.example.Api_Rest_JAVA_SpringBoot.repository.PlanetRepository;
import com.example.Api_Rest_JAVA_SpringBoot.services.PlanetService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/planetas")
public class PlanetsController {
    @Autowired
    private PlanetService planetService;

    public PlanetsController(PlanetService planetService){this.planetService = planetService;}

    @PostMapping
    public ResponseEntity<Response<PlanetResponseDto>> postPlanet(@Valid @RequestBody PlanetRequestDto dto){

        PlanetResponseDto planet = planetService.insertPlanet(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>(
                true,
                "Planeta creado correctamente",
                planet
        ));
    }

    @GetMapping
    public List<PlanetResponseDto> getPlanets(){return planetService.listPlanet();}

    @GetMapping("/{id}")
    public PlanetResponseDto getPlanetbyId(@PathVariable int id){return  planetService.getPlanetById(id);}

    @PutMapping("/{id}")
    public ResponseEntity<Response<PlanetResponseDto>> updatePlanet (@Valid @PathVariable int id,
                            @RequestBody PlanetRequestDto dto) {
        PlanetResponseDto planet = planetService.updatePlanet(id, dto);
        return ResponseEntity.ok(
                new Response<>(
                true,
                "Planeta actualizado correctamente",
                planet
                ));

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Response<Void>> deletePlanet(@PathVariable int id){
        planetService.deletePlanet(id);

        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "",
                        null

                ));
    }





}
