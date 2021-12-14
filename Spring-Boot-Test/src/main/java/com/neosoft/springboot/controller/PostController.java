package com.neosoft.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.Post;
import com.neosoft.springboot.myexception.ResourceNotFoundException;
import com.neosoft.springboot.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	@PostMapping("/posts")
	public Post createPost(@Valid @RequestBody Post post) {
		return postRepository.save(post);
	}
	
	@PutMapping("/posts/{postId}")
	public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postReq) {
		
		return postRepository.findById(postId).map(post -> {
			post.setTitle(postReq.getTitle());
			post.setDescription(postReq.getDescription());
			post.setContent(postReq.getContent());
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
	}	
	
	@DeleteMapping("/posts/{postId}")
	public void deletePost(@PathVariable Long postId) {
		
		postRepository.findById(postId).map(post -> {
			postRepository.delete(post);
			return post;
		}).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
	}	
}
