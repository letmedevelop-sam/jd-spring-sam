package com.cybertek.controller;

import com.cybertek.entity.Genre;
import com.cybertek.entity.MovieCinema;
import com.cybertek.repository.GenreRepository;
import com.cybertek.repository.MovieCinemaRepository;
import com.cybertek.repository.MovieRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    public WebFluxController(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
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

       //--------------------------- WEBCLIENT EXAMPLE--------------------

    @GetMapping("/flux")  // we will call http://localhost:8080/flux and it will consume --** /flux-movie-cinemas **-- API
    public Flux<MovieCinema> readWithWebClient(){
        return webClient
                .get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }


    //with @PathVariable
    @GetMapping("/mono/{id}")       //    http://localhost:8080/mono/1
    public Mono<MovieCinema> redMonoWithWebClient(@PathVariable("id") Long id){
        return  webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);

    }


    //with @RequestParam
    @GetMapping("/mono-rp")
    public Mono<MovieCinema> readMonoWithWebclientRequestParam(@RequestParam("id") Long id){
        return webClient
                .get()
                .uri(uriBuilder ->              //with @RequestParam we use builder
                        uriBuilder
                .path("/mono-movie-cinema")     //we dont have access to that DB but we retrieve info from this API
                .queryParam("id",id)
                                .build()
                )
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }


    @PostMapping("/create")
    public Mono<Genre> createWebClient(@RequestBody Genre genre){
        return webClient
                .post()
                .uri("/create-genre")
                .body(Mono.just(genre),Genre.class)  // only this part different
                .retrieve()
                .bodyToMono(Genre.class);
    }

//    @DeleteMapping("/delete/{id}")
//    public Mono<Void> deleteWebClient(@PathVariable("id") Long id){
//        return webClient.delete()
//                .uri("/delete-genre/{id}",id)
//                .retrieve()
//                .bodyToMono(Void.class);
//    }


    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteWebClient(@PathVariable("id") Long id) throws Exception {

        Integer countGenres = genreRepository.countGenresNativeQuery(id);
        if (countGenres > 0) {
            throw new Exception("Genre can't be deleted, is linked by a movie");
        }

        return webClient.delete()
                .uri("/delete-genre/{id}",id)
                .retrieve()
                .bodyToMono(Void.class);
    }


}
