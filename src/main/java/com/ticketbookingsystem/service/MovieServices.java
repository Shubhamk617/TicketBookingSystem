/**
 * 
 */
package com.ticketbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ticketbookingsystem.model.Movie;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName MovieServices.java
 * @Description
 */
@Service
public interface MovieServices {

	public Movie saveMovie(Movie movie);

	public List<Movie> saveMovieAll(List<Movie> movie);

	public List<Movie> getMovies();

	public Optional<Movie> getMovieById(int movieId);

	public void updateMovie(Movie movie);

	public void deleteMovie(Movie movie);

	public void deleteMovieById(int movieId);

}
