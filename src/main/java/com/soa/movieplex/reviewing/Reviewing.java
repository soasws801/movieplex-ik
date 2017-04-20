/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.reviewing;

import com.soa.movieplex.client.MovieReviewBackingBean;
import com.soa.movieplex.entities.Movie;
import com.soa.movieplex.entities.MovieReviews;
import com.soa.movieplex.entities.ShowTiming;
import java.io.Serializable;
import java.util.List;
import java.util.StringTokenizer;
import javax.annotation.Resource;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Eric Desrochers
 */
@Named
@FlowScoped("reviewing")
public class Reviewing implements Serializable {

    int movieId;
    String startTime;
    int startTimeId;
    @PersistenceContext
    EntityManager entityManager;

    @Inject
    MovieReviewBackingBean bean;
    
    @Resource
    private UserTransaction userTransaction;
    
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        try {

            return entityManager.createNamedQuery("Movie.findById", Movie.class).setParameter("id", movieId).getSingleResult().getName();
        } catch (NoResultException e) {
            return "";
        }
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        StringTokenizer tokens = new StringTokenizer(startTime, ",");
        startTimeId = Integer.parseInt(tokens.nextToken());
        this.startTime = tokens.nextToken();
    }

    public int getStartTimeId() {
        return startTimeId;
    }

    public String getTheater() {
        // for a movie and show
        try {
            // Always return the first theater
            List<ShowTiming> list = entityManager.createNamedQuery(
                    "ShowTiming.findByMovieAndTimeslotId",
                    ShowTiming.class).setParameter("movieId", movieId).setParameter("timeslotId",
                    startTimeId).getResultList();
            if (list.isEmpty()) {
                return "none";
            }
            return list.get(0).getTheater().getId().toString();
        } catch (NoResultException e) {
            return "none";

        }
    }

    public void addReview() throws Exception {
        userTransaction.begin();
        MovieReviews review = new MovieReviews(bean.getReviewId(), bean.getCustomerName(), bean.getMovieRating(), bean.getMovieComment());
        Movie movie = new Movie(movieId);
        review.setMovie(movie);
        
        entityManager.persist(review);
        userTransaction.commit();
    }
}
