package com.codegym.service;

import com.codegym.model.Comment;
import com.codegym.repository.ICommentRepository;


import java.util.Optional;

public interface ICommentService {
    Iterable<Comment> findAll();

    Optional<Comment> findById(Long id);

    void save(Comment comment);

    void remove(Long id);

}
