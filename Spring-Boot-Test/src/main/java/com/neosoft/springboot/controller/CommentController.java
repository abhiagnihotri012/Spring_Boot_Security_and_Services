package com.neosoft.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.Comment;
import com.neosoft.springboot.myexception.ResourceNotFoundException;
import com.neosoft.springboot.repository.CommentRepository;
import com.neosoft.springboot.repository.PostRepository;

@RestController
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/comments")
	public List<Comment> getAllComments(){
		return commentRepository.findAll();
	}
	
	@GetMapping("/posts/{postId}/comments")
	public List<Comment> getAllCommentsByPostId(@PathVariable Long postId){
		return commentRepository.findByPostId(postId);
	}
	
	@GetMapping("/comments/{id}")
	public Optional<Comment> getCommentById(@PathVariable Long id) {
		return commentRepository.findById(id);
	}
	
	@GetMapping("/posts/{postId}/comments/{id}")
	public Comment getCommentByIdAndPostId(@PathVariable Long postId, @PathVariable Long id) {
		return commentRepository.findByIdAndPostId(id,postId);
	}
	
	@PostMapping("/posts/{postId}/comments")
	public Comment createComment(@PathVariable Long postId, @Valid @RequestBody Comment comment) {
		return postRepository.findById(postId).map(post -> {
			comment.setPost(post);
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
	}
	
	@PutMapping("/comments/{id}")
	public Comment updateComment(@PathVariable Long id, @Valid @RequestBody Comment commentReq) {
		return commentRepository.findById(id).map(comment -> {
			comment.setText(commentReq.getText());
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", id));
	}
	
	@DeleteMapping("/comments/{id}")
	public void deleteComment(@PathVariable Long id) {
		commentRepository.findById(id).map(comment -> {
			commentRepository.delete(comment);
			return comment;
		}).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", id));
	}	
}
