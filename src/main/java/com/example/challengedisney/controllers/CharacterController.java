package com.example.challengedisney.controllers;
import com.example.challengedisney.entities.Character;
import com.example.challengedisney.entities.User;
import com.example.challengedisney.services.CharacterService;
import com.example.challengedisney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;


    @Autowired
    public  CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping("/images")
    private List<Map<String, String>> listarPersonajes(@RequestParam Optional<String> tokenTemporal){
        return (tokenEsValido(tokenTemporal))?characterService.listarPersonajes():null;
    }

    private boolean tokenEsValido(Optional<String> tokenTemporal) {
        if(tokenTemporal.isPresent())
            return true;
        return false;
    }

    @GetMapping("/all")
    private List<Character>listarTodosLosPersonajes(Optional <String> tokenTemporal){
        return characterService.listarAllPersonajes();
    }

    @GetMapping("/{id}")
    private Character getPersonajeById(@PathVariable Integer id){
        return characterService.getCharacterById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    private List<Character> buscar(@RequestParam Optional<String>name, @RequestParam Optional<Integer>age, @RequestParam Optional<Integer> movies){
        return characterService.findCharacters(name, age, movies);
    }


    @PostMapping(path="/save", consumes = "application/json")
    private void save(@RequestBody Character personaje){
        characterService.save(personaje);
    }

    @DeleteMapping("/borrar/{id}")
    private void borrar(@PathVariable Integer id){
        characterService.delete(id);
    }

}
