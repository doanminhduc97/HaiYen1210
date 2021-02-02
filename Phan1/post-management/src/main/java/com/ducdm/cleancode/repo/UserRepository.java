package com.ducdm.cleancode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducdm.cleancode.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
