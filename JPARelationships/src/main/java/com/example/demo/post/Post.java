package com.example.demo.post;

import com.example.demo.category.Category;
import com.example.demo.file.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String title;
    private String context;

    @OneToOne(fetch = FetchType.EAGER)
    private Category category;
    @OneToMany(mappedBy ="post")
    @Column(name ="file_id")
    List<FileEntity> files;
}
