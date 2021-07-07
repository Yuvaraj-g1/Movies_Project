package com.rakuten.training.dal;

import java.util.List;

import com.rakuten.training.domain.Movie;

public interface MovieDAO {
 
	public List<Movie> findAll();
	public Movie findById(int id);
	public Movie addMovie(Movie tobeAdded);
	public List<Movie> findByActor(String actorName);
	public List<Movie> findByGenre(String genreName);
	
	
	
}
