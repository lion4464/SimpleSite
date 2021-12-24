package com.example.demo.file;

import org.springframework.stereotype.Component;

@Component
public class FileConvertor {
     public FileDTO convert(FileDTO to,FileEntity from){
          to.setId(from.getId());
          to.setName(from.getName());
          to.setExtension(from.getExtension());
          to.setSize(from.getSize());
          return to;
     }
}
