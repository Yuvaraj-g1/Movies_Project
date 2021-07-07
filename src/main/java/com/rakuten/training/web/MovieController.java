package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Movie;
import com.rakuten.training.service.MovieService;

@CrossOrigin
@RestController
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return service.getAll();
	}
	

	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getById(@PathVariable("id") int id) {
		Movie p = service.getById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Movie>(p, HttpStatus.OK);
		}
	}

	
	@PostMapping("/movies")
	public ResponseEntity addNewMovie(@RequestBody Movie toBeAdded) {
	     try {
	    	 int id = service.addNewMovie(toBeAdded);
	    	 HttpHeaders headers = new HttpHeaders();
	    	 headers.setLocation(URI.create("/products/" + id));
	    	 return new ResponseEntity(toBeAdded, headers, HttpStatus.CREATED);
	     	} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/movies/actor/{actorName}")
	public ResponseEntity getByActorName(@PathVariable("actorName") String actorName)
	{
	   	List<Movie> l=service.getByActor(actorName);
	   	return new ResponseEntity<List<Movie>>(l, HttpStatus.OK);
	   	
	}
	@GetMapping("/movies/genre/{genreName}")
	public ResponseEntity getByGenreName(@PathVariable("genreName") String genreName)
	{
	   	List<Movie> l=service.getByGenre(genreName);
	   	return new ResponseEntity<List<Movie>>(l, HttpStatus.OK);
	   	
	}

	
}
