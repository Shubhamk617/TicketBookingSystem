/**
 * 
 */
package com.ticketbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbookingsystem.dao.MovieRepository;
import com.ticketbookingsystem.model.Movie;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName MovieServicesImpl.java
 * @Description
 */
@Service
public class MovieServicesImpl implements MovieServices {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> getMovieById(int movieId) {
		// TODO Auto-generated method stub
		return movieRepository.findById(movieId);
	}

	@Override
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepository.save(movie);

	}

	@Override
	public void deleteMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepository.delete(movie);

	}

	@Override
	public void deleteMovieById(int movieId) {
		// TODO Auto-generated method stub
		movieRepository.deleteById(movieId);
	}

	@Override
	public List<Movie> saveMovieAll(List<Movie> movie) {
		// TODO Auto-generated method stub
		return movieRepository.saveAll(movie);
	}

}
