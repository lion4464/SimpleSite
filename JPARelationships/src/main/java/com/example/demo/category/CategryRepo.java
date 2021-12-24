package com.example.demo.category;

import com.example.demo.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategryRepo extends JpaRepository<Category,Long> {
}
