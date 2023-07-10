package com.example.post.controllers;


import com.example.post.dtos.PostCreateDTO;
import com.example.post.dtos.PostUpdateDTO;
import com.example.post.dtos.PostViewDTO;
import com.example.post.service.interfaces.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/getall")
    public ResponseEntity<List<PostViewDTO>> getAll(@RequestParam Long userId) {
        if (userId != null && !postService.getALlPostByUserId(userId).isEmpty()) {
            return new ResponseEntity<>(postService.getALlPostByUserId(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostViewDTO> getPostById(@PathVariable Long id) {
        if (id != null && this.postService.getPostById(id) != null) {
            return new ResponseEntity<>(this.postService.getPostById(id), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public PostViewDTO createPost(@Valid @RequestBody PostCreateDTO postCreateDTO) {
        return postService.createPost(postCreateDTO);

    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @Valid @RequestBody PostUpdateDTO postUpdateDTO) {
        if (postService.getPostById(id) == null && id != null) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(postService.updatePost(id, postUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {

        if (postService.getPostById(id) == null && id != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ressource non trouvé");
        }

        postService.deletePost(id);
        return ResponseEntity.status(204).build();


    }


}

