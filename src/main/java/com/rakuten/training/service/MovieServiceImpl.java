package com.rakuten.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.MovieDAO;
import com.rakuten.training.domain.Movie;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieDAO dao;

	@Override
	public int addNewMovie(Movie toBeAdded) {
		Movie saved=dao.addMovie(toBeAdded);
		return saved.getId();
	}


	@Override
	public List<Movie> getAll() {
		return dao.findAll();
	}

	@Override
	public Movie getById(int id) {
		return dao.findById(id);
	}


	@Override
	public List<Movie> getByActor(String actorName) {
		return dao.findByActor(actorName);
	}


	@Override
	public List<Movie> getByGenre(String genreName) {
		return dao.findByGenre(genreName);
	}

}
