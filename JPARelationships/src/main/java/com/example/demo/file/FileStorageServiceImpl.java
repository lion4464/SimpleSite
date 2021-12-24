package com.example.demo.file;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
@Service
public class FileStorageServiceImpl implements FileStorageService{
    private final FileRepository fileRepository;
    private final Path fileStorageLocation;

    public FileStorageServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
        this.fileStorageLocation=Paths.get("uploads").toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public FileEntity save(MultipartFile file) {
        return fileRepository.save(saveFile(file));
    }

    private FileEntity saveFile(MultipartFile file) {
    }

    @Override
    public Resource load(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }
}
