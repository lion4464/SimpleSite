package com.example.demo.post;

import org.springframework.stereotype.Component;

@Component
public class PostConvertor {
    public PostDTO convert(PostDTO to, Post from){
        to.setId(from.getId());
        to.setContext(from.getContext());
        to.setTitle(from.getTitle());
        to.setCategory(from.getCategory());
        return  to;
    }
}
