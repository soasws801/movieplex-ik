package com.soa.movieplex.entities;

import com.soa.movieplex.entities.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-19T20:31:28")
@StaticMetamodel(MovieReviews.class)
public class MovieReviews_ { 

    public static volatile SingularAttribute<MovieReviews, Movie> movie;
    public static volatile SingularAttribute<MovieReviews, Integer> rating;
    public static volatile SingularAttribute<MovieReviews, Integer> movieId;
    public static volatile SingularAttribute<MovieReviews, String> comment;
    public static volatile SingularAttribute<MovieReviews, Integer> id;
    public static volatile SingularAttribute<MovieReviews, String> customer;

}