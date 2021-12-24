package com.example.demo.category;

import com.example.demo.category.Category;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.ResourceAlreadyExistsException;
import com.example.demo.category.CategryRepo;
import com.example.demo.service.AllActionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements AllActionService<Category,Long> {
    private final CategryRepo categryRepo;

    public CategoryService(CategryRepo categryRepo) {
        this.categryRepo = categryRepo;
    }

    @Override
    public List<Category> getAll() throws NotFoundException {
        List<Category> posts;
        if (categryRepo.findAll().size()>0)
            posts=categryRepo.findAll();
        else
            throw new NotFoundException("Resource Not found:(");
        return posts;
    }

    @Override
    public Category findById(Long id) throws NotFoundException {
        Category post;
        if (!categryRepo.findById(id).isPresent())
            throw new NotFoundException("This resource not found :/");
        else
            post=categryRepo.findById(id).get();
        return post;

    }

    @Override
    public Category insert(Category obj) throws ResourceAlreadyExistsException {
        Category category;
        if (categryRepo.findById(obj.getId()).isPresent())
            throw new ResourceAlreadyExistsException("Resource Already exist :)");
        else
            category=categryRepo.save(obj);
        return category;
    }

    @Override
    public Category update(Category obj, Long id) throws NotFoundException {
        Category category;
        if (!categryRepo.findById(obj.getId()).isPresent())
            throw new NotFoundException("Resource NotFound  :(");
        else {
            Category thisCategory = categryRepo.findById(id).get();
            thisCategory.setName(obj.getName());

            return categryRepo.save(thisCategory);
        }
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        if (!categryRepo.findById(id).isPresent())
            throw new NotFoundException("This Resource not found  :(");
        else
            categryRepo.deleteById(id);
    }


}
