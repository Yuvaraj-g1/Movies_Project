package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rakuten.training.domain.Movie;

@Repository
@Transactional
public class MovieDAOJpaImpl implements MovieDAO{
	
	@Autowired
	EntityManager em;

	@Override
	public List<Movie> findAll() {
		Query q = em.createQuery("select m from Movie as m");
		return q.getResultList();
	}

	@Override
	public Movie findById(int id) {
		return em.find(Movie.class,id);
	}

	@Override
	public Movie addMovie(Movie tobeAdded) {
		em.persist(tobeAdded);
		return tobeAdded;
	}

	@Override
	public List<Movie> findByActor(String actorName) {
		Query q = em.createQuery("select m from Movie m where m.actors like :n");
		q.setParameter("n", "%"+actorName+"%");
		return q.getResultList();
	}

	@Override
	public List<Movie> findByGenre(String genreName) {
		Query q = em.createQuery("select m from Movie m where m.genre =:n");
		q.setParameter("n",genreName);
		return q.getResultList();
	}

}
