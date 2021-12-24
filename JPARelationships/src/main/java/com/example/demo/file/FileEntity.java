package com.example.demo.file;

import com.example.demo.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String extension;
    private Long Size;

    @ManyToOne(fetch = FetchType.LAZY)
    Post post;

public FileEntity(String name,String extension,Long Size){
    this.name = name;
    this.extension = extension;
    this.Size = Size;
}
}
