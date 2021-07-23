package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface IUserService {
    Page<User> findAllByFirstNameContainingAndLastNameContaining(String firstName,String lastName,Pageable pageable);
    Page<User> findAll(Pageable pageable);
    Iterable<User> findAll();
    Optional<User> findUserById(Long id);
    void save(User user);
    void remove(Long id);
    Optional<User> findUserByFirstNameAndLastName(String firstName,String lastName);


}
