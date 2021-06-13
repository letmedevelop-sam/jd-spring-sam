package com.cybertek.controller;

import com.cybertek.entity.Genre;
import com.cybertek.entity.MovieCinema;
import com.cybertek.repository.GenreRepository;
import com.cybertek.repository.MovieCinemaRepository;
import com.cybertek.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class WebFluxController {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    private MovieCinemaRepository movieCinemaRepository;
    private GenreRepository genreRepository;

    public WebFluxController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux(){
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    //with @PathVariable
    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id") Long id){
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    // same thing as previous but with @RequestParam
    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema> readByRequestParam(@RequestParam("id") Long id){
        return  Mono.just(movieCinemaRepository.findById(id).get());
    }


    @PostMapping("/create-genre")
    public  Mono<Genre> createGenre (@RequestBody Genre genre){
        Genre createdGenre = genreRepository.save(genre);
        return Mono.just(createdGenre);
    //    return Mono.just(genreRepository.save(genre));  // same with the previous line
    }

    @PutMapping("/update-genre")
    public Mono<Genre> updatedGenre(@RequestBody Genre genre){
        Genre updatedGenre = genreRepository.save(genre);
        return  Mono.just(updatedGenre);
    }

    @DeleteMapping("/delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
        return Mono.empty();
    }

}
