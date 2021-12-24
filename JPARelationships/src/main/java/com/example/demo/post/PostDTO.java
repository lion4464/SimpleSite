package com.example.demo.post;

import com.example.demo.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDTO {
    private long id;
    private String title;
    private String context;
    private Category category;
}
