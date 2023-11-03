package com.example.moviecrud.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int totalReviewScore;

    public Movie(int id, String name, String description, int totalReviewScore) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.totalReviewScore = totalReviewScore;
    }

    public Movie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalReviewScore() {
        return totalReviewScore;
    }

    public void setTotalReviewScore(int totalReviewScore) {
        this.totalReviewScore = totalReviewScore;
    }
}
