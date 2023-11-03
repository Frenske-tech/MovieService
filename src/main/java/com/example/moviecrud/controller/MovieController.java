package com.example.moviecrud.controller;

import com.example.moviecrud.model.Movie;
import com.example.moviecrud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public String add(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return "Movie added"+ movie.getName();

    }

    @GetMapping("getall")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public void deleteReview(@PathVariable int id){
        movieService.deleteMovie(id);
    }

}

