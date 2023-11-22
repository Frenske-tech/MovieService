package com.example.moviecrud.service;

import com.example.moviecrud.model.Movie;
import com.example.moviecrud.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public void deleteMovie(int id) {
        movieRepo.deleteById(id);
    }

    @Override
    public Movie editMovie(Movie movie){
        movieRepo.findById(movie.getId());
        return movieRepo.save(movie);
    }
}
