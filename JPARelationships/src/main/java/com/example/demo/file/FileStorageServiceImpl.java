package com.example.demo.file;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;
import org.apache.commons.io.FilenameUtils;

@Service
public class FileStorageServiceImpl implements FileStorageService{
    @Value("${storage.upload_dir}")
    private String uploadDir;

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
        try {
            return fileRepository.save(saveFile(file));
        } catch (IOException e) {
            throw new RuntimeException("You can't save file to DB :/");
        }
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


    private FileEntity saveFile(MultipartFile file) throws IOException{
        String guid = generateGuid();
        String extension = FilenameUtils .getExtension(file.getOriginalFilename());
        Path uploadPath = Paths.get(uploadDir+ File.separator+guid+"."+extension);
        Files.copy(file.getInputStream(),uploadPath, StandardCopyOption.REPLACE_EXISTING);
        return new FileEntity(file.getOriginalFilename(),extension,file.getSize());
    }

    private String generateGuid() {
        return RandomString.make(20)+System.currentTimeMillis()+RandomString.make(20);
    }
}
