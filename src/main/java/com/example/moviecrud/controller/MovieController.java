package com.example.moviecrud.controller;

import com.example.moviecrud.model.Movie;
import com.example.moviecrud.producer.RabbitMQJsonProducer;
import com.example.moviecrud.producer.RabbitMQProducer;
import com.example.moviecrud.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
//@CrossOrigin("*")
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
    private RabbitMQJsonProducer jsonProducer;
    private RabbitMQProducer producer;

    public MovieController(RabbitMQJsonProducer jsonProducer, RabbitMQProducer producer) {
        this.jsonProducer = jsonProducer;
        this.producer = producer;
    }

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public String add(@RequestBody Movie movie){
        jsonProducer.sendJsonMessage(movie);
        ResponseEntity.ok("Json message sent to rabbitmq");
        movieService.saveMovie(movie);
        return "Movie added"+ movie.getName();

    }

    @GetMapping("getall")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public void deleteMovie(@PathVariable int id){
        producer.sendMessage(String.valueOf(id));
        movieService.deleteMovie(id);
    }


}

