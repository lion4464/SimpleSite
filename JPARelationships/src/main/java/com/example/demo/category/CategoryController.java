package com.example.demo.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;
    private final CatConvertor catConvertor;

    public CategoryController(CategoryService categoryService, CatConvertor catConvertor) {
        this.categoryService = categoryService;
        this.catConvertor = catConvertor;
    }
    @GetMapping("/allC")
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAll());
    }
    @PostMapping("insertC")
    public ResponseEntity<CategoryDTO> Insert(@RequestBody Category cat){
        CategoryDTO to=new CategoryDTO();
        Category from=categoryService.insert(cat);
        return ResponseEntity.ok(catConvertor.convert(to,from));
    }
    @GetMapping("/findC/{id}")
    public ResponseEntity<CategoryDTO> findPost(@PathVariable("id") long id){
        CategoryDTO to=new CategoryDTO();
        Category from=categoryService.findById(id);
        return ResponseEntity.ok(catConvertor.convert(to,from));
    }
    @PutMapping("/updateC")
    public ResponseEntity<CategoryDTO> UpdatePost(@RequestBody Category category){
        Category  from=categoryService.update(category, category.getId());
        CategoryDTO to=new CategoryDTO();
        return ResponseEntity.ok(catConvertor.convert(to,from));
    }
    @DeleteMapping("/deleteC/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable("id") long id){
         categoryService.deleteById(id);
        return new ResponseEntity<>("id="+id+" Successfully removed :)",HttpStatus.NO_CONTENT);
    }


}
