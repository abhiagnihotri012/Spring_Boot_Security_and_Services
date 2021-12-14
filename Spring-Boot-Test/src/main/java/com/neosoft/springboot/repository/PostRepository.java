package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
