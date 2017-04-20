/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ibrahim
 */
@Entity
@Table(name = "MOVIE_REVIEWS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovieReviews.findAll", query = "SELECT m FROM MovieReviews m"),
    @NamedQuery(name = "MovieReviews.findById", query = "SELECT m FROM MovieReviews m WHERE m.id = :id"),
    @NamedQuery(name = "MovieReviews.findByMovieId", query = "SELECT m FROM MovieReviews m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "MovieReviews.findByCustomer", query = "SELECT m FROM MovieReviews m WHERE m.customer = :customer"),
    @NamedQuery(name = "MovieReviews.findByRating", query = "SELECT m FROM MovieReviews m WHERE m.rating = :rating"),
    @NamedQuery(name = "MovieReviews.findByComment", query = "SELECT m FROM MovieReviews m WHERE m.comment = :comment")})
public class MovieReviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;    
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")
    @ManyToOne(optional = false)
    private Integer movieId;
    @Size(max = 255)
    @Column(name = "CUSTOMER")
    private String customer;
    @Column(name = "RATING")
    private Integer rating;
    @Size(max = 255)
    @Column(name = "COMMENT")
    private String comment;
    @ManyToOne(optional = false)
    private Movie movie;
    
    public MovieReviews() {
    }

    public MovieReviews(Integer id) {
        this.id = id;
    }

    public MovieReviews(int reviewId, String customerName, int movieRating, String movieComment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieReviews)) {
            return false;
        }
        MovieReviews other = (MovieReviews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soa.movieplex.entities.MovieReviews[ id=" + id + " ]";
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
    
    
}
