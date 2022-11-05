package labs.lab5.Controller;

import labs.lab5.Anotations.ExecutionTime;
import labs.lab5.Entity.UniProduct;
import labs.lab5.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    @ExecutionTime
    public ResponseEntity<List<UniProduct>> getProducts(){
        return new ResponseEntity<>(this.productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniProduct> getProductById(@PathVariable String id){
        UniProduct pr = this.productService.getProductById(id);
        if(pr != null)
            return new ResponseEntity<>(pr, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/filter/price")
    public ResponseEntity<List<UniProduct>> filterByPrice(@RequestParam double minPrice){
        return new ResponseEntity<>(this.productService.filterProductsByMinPrice(minPrice), HttpStatus.OK);
    }

    @GetMapping("/filter/productname")

    public ResponseEntity<List<UniProduct>> filterProductsByName(@RequestParam String keyword){
        return new ResponseEntity<>(this.productService.filterProductsNameContainKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/filter/catandprice")
    public ResponseEntity<List<UniProduct>> filterProductsByCatAndPrice(@RequestParam Map<String, String> params){
        String cat = params.get("cat");
        double maxPrice = Double.parseDouble(params.get("maxPrice"));
        return new ResponseEntity<>(this.productService.filterProductsByCatAndPrice(cat, maxPrice), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody UniProduct pr){
        UniProduct p = this.productService.saveProduct(pr);
        if(p!=null)
            return new ResponseEntity<>("success", HttpStatus.OK);
        else
            return new ResponseEntity<>("unable to complete request", HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody UniProduct pr){
        UniProduct p = this.productService.saveProduct(pr);
        if(p!=null)
            return new ResponseEntity<>("success added product", HttpStatus.OK);
        else
            return new ResponseEntity<>("unable to complete request", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable String id){
        this.productService.deleteProductById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
