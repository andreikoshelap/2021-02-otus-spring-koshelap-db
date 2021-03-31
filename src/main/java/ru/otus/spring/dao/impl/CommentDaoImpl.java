package ru.otus.spring.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.CommentDao;
import ru.otus.spring.domain.Comment;

@Repository
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Comment getById(long id) {
        return em.find(Comment.class, id);
    }

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == 0) {
            em.persist(comment);
            return comment;
        } else {
            return em.merge(comment);
        }
    }

}
