package com.example.demo.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService {
    public FileEntity save(MultipartFile file);
    public Resource  load(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();
}
