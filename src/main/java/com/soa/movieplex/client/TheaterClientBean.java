/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.client;


import com.soa.movieplex.entities.Theater;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Ibrahim Khalid
 */
@Named
@RequestScoped
public class TheaterClientBean {
     @Inject
    TheaterBackingBean bean;
    
    Client client;
    WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/movieplex/rest/theaters/");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    public Theater[] getTheaters() {
        return target.request().get(Theater[].class);
    }

    public Theater getTheater() {
        Theater theater = target.path("{theaterId}").resolveTemplate("theaterId", bean.getTheaterId()).request().get(Theater.class);
        return theater;
    }
}
