package ru.otus.spring.dao;

import ru.otus.spring.domain.Comment;

public interface CommentDao {

    Comment getById(long i);

    Comment save(Comment comment);

}
