package com.example.demo.post;

import com.example.demo.post.PostConvertor;
import com.example.demo.post.Post;
import com.example.demo.post.PostDTO;
import com.example.demo.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class PostController {

    private final PostService postService;
    private final PostConvertor dtOtoJPAConvertor;

    public PostController(PostService postService, PostConvertor dtOtoJPAConvertor) {
        this.postService = postService;
        this.dtOtoJPAConvertor = dtOtoJPAConvertor;
    }

    @GetMapping("/allP")
    public ResponseEntity<List<Post>> getAllPosts(){
       return ResponseEntity.ok(postService.getAll());
    }

    @PostMapping("/insertP")
    public  ResponseEntity<Object> InsertPost(@RequestBody Post obj){
        PostDTO obj1=new PostDTO();
        Post redyForView=postService.insert(obj);
        return ResponseEntity.ok(dtOtoJPAConvertor.convert(obj1,redyForView));
    }
    @GetMapping("/findP/{id}")
    public ResponseEntity<PostDTO> findPost(@PathVariable("id") long id){
        PostDTO obj1=new PostDTO();
        Post redyForView=postService.findById(id);
        return ResponseEntity.ok(dtOtoJPAConvertor.convert(obj1,redyForView));
    }
    @PutMapping("/updateP")
    public ResponseEntity<PostDTO> UpdatePost(@RequestBody Post post){
        Post  from=postService.update(post, post.getId());
        PostDTO to=new PostDTO();
        return ResponseEntity.ok(dtOtoJPAConvertor.convert(to,from));
    }
    @DeleteMapping("/deleteP/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable("id") long id){
        postService.deleteById(id);
        return new ResponseEntity<>("id="+id+" Successfully removed :)",HttpStatus.NO_CONTENT);
    }








}
