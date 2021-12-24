package com.example.demo.file;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
    private final FileStorageService fileStorageService;
    private final FileConvertor fileConvertor;

    public FileController(FileStorageService fileStorageService, FileConvertor fileConvertor) {
        this.fileStorageService = fileStorageService;
        this.fileConvertor = fileConvertor;
    }

    @PostMapping("upload")
    public ResponseEntity<FileDTO> Upload(@RequestParam("file") MultipartFile uploadedFile) throws IOException{
        FileDTO obj1=new FileDTO();
        return ResponseEntity.ok(fileConvertor.convert(obj1,fileStorageService.save(uploadedFile)));
    }
}
