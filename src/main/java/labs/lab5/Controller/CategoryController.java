package labs.lab5.Controller;

import labs.lab5.Anotations.ExecutionTime;
import labs.lab5.Entity.UniCategory;
import labs.lab5.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    CategoryService categoryService;

    @GetMapping
    @ExecutionTime
    public ResponseEntity<UniCategory> getCategories(){
        return new ResponseEntity(this.categoryService.getCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniCategory> getCategoryById(@PathVariable String id){
        UniCategory cat = this.categoryService.getCategoryById(id);
        if(cat != null)
            return new ResponseEntity<>(cat, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addCategory(UniCategory c){
        UniCategory cat = this.categoryService.saveCategory(c);
        if(cat != null)
            return new ResponseEntity<>("successfully added category", HttpStatus.OK);
        else
            return new ResponseEntity<>("unable to add category", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity updateCategory(@RequestBody UniCategory c ){
        UniCategory cat = this.categoryService.saveCategory(c);
        if(cat != null)
            return new ResponseEntity<>(cat, HttpStatus.OK);
        else
            return new ResponseEntity<>("unable to update category", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable String id){
        this.categoryService.deleteCategoryById(id);
        return new ResponseEntity<>("category deleted", HttpStatus.OK);
    }
}
