package com.example.demo.category;

import org.springframework.stereotype.Component;

@Component
public class CatConvertor {
    public CategoryDTO convert(CategoryDTO to, Category from){
        to.setId(from.getId());
        to.setName(from.getName());
        return to;
    }
}
