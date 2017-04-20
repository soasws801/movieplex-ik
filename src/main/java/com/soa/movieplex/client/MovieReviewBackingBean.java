/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.client;

import com.soa.movieplex.client.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Ibrahim Khalid
 */
@Named
@SessionScoped
public class MovieReviewBackingBean implements Serializable {

    int reviewId;
    int movieId;
    int movieRating;
    String customerName;
    String movieComment;

    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieId() {
        return movieId;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public int getMovieRating() {
        return movieRating;
    }
    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieComment() {
        return movieComment;
    }
    public void setMovieComment(String movieComment) {
        this.movieComment = movieComment;
    }
}
