package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
    Page<User> findAllByFirstNameContainingAndLastNameContaining(String firstName, String lastName, Pageable pageable);
    Page<User> findAll(Pageable pageable);
    Optional<User> findUserByFirstNameAndLastName(String firstName,String lastName);
}
