package com.example.challengedisney.repositories;


import com.example.challengedisney.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.challengedisney.entities.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    List<Character> findCharactersByNameContaining(String name);

    List<Character> findCharactersByNameContainingAndAgeEqualsAndMoviesContaining(String s, Integer integer, Movie movie);

    List<Character> findCharactersByNameContainingAndMoviesContaining(String s, Movie movie);

    List<Character> findCharactersByAgeEqualsAndMoviesContaining(Integer integer, Movie movie);

    List<Character> findCharactersByMoviesContaining(Movie movie);

    List<Character> findCharactersByNameContainingAndAgeEquals(String s, Integer integer);

    List<Character> findCharactersByAgeEquals(Integer integer);
}
