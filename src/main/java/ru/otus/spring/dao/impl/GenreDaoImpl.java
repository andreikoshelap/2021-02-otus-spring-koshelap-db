package ru.otus.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Genre;

@Repository
public class GenreDaoImpl implements GenreDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre getByKey(String key) {
        TypedQuery<Genre> query = em.createQuery("select g " +
                        "from Genre g " +
                        "where substring(g.genreName, 1, 1) = :key",
                Genre.class);
        query.setParameter("key", key);
        return query.getSingleResult();

    }

    @Override
    public Genre save(Genre genre) {
        if (genre.getId() == 0) {
            em.persist(genre);
            return genre;
        } else {
            return em.merge(genre);
        }
    }

    @Override
    public List<Genre> getGenreList() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g",
                Genre.class);
        return query.getResultList();
    }

}
