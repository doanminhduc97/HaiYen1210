package com.ducdm.cleancode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducdm.cleancode.entity.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
