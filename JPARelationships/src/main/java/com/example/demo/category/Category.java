package com.example.demo.category;

import com.example.demo.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
}
