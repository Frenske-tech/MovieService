package com.example.moviecrud.service;

import com.example.moviecrud.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public Movie saveMovie(Movie movie);
    public List<Movie> getAllMovies();

    void deleteMovie(int id);
    public Movie editMovie(Movie movie);
}
