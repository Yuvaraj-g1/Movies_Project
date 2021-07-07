package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Movie;

public interface MovieService {
	
public int addNewMovie(Movie toBeAdded);
	
	public List<Movie> getAll();
	
	public Movie getById(int id);
	
	public List<Movie> getByActor(String actorName);
	
	public List<Movie> getByGenre(String genreName);

}

