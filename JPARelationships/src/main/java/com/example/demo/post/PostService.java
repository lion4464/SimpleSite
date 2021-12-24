package com.example.demo.post;

import com.example.demo.post.Post;
import com.example.demo.post.PostDTO;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.ResourceAlreadyExistsException;
import com.example.demo.post.PostRepo;
import com.example.demo.service.AllActionService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements AllActionService<Post,Long> {
    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> getAll() throws NotFoundException {
        List<Post> posts;
        if (postRepo.findAll().size()>0)
            posts=postRepo.findAll();
        else
            throw new NotFoundException("Resource Not found:(");
        return posts;
    }

    @Override
    public Post findById(Long id) throws NotFoundException{
        Post post;
      if (!postRepo.findById(id).isPresent())
          throw new NotFoundException("This resource is not found!!! :/");
      else
          post=postRepo.findById(id).get();
      return post;
    }

    @Override
    public Post insert(Post obj) throws ResourceAlreadyExistsException {
        Post post;
        if (postRepo.findById(obj.getId()).isPresent())
            throw new ResourceAlreadyExistsException("Resource Already exist :)");
        else
            post=postRepo.save(obj);
        return post;
    }

    @Override
    public Post update(Post obj, Long id) throws NotFoundException {
        Post post;
        if (!postRepo.findById(obj.getId()).isPresent())
            throw new NotFoundException("Resource NotFound  :(");
        else {
            Post thisPost = postRepo.findById(id).get();
            thisPost.setTitle(obj.getTitle());
            thisPost.setContext(obj.getContext());
            thisPost.setCategory(obj.getCategory());

            return postRepo.save(thisPost);
            }
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        if (!postRepo.findById(id).isPresent())
            throw new NotFoundException("This Resource not found  :(");
        else
            postRepo.deleteById(id);
    }


}
