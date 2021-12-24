package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.ResourceAlreadyExistsException;

import java.util.List;


public interface AllActionService<T,V>{
    List<T> getAll() throws NotFoundException;
    T findById(V id) throws NotFoundException;
    T insert(T obj) throws ResourceAlreadyExistsException;
    T update(T obj,V id) throws NotFoundException;
    void deleteById(V id) throws NotFoundException;
}
