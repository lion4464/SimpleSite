package com.example.demo.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDTO {
    private Long id;
    private String name;
    private String extension;
    private Long Size;
}
