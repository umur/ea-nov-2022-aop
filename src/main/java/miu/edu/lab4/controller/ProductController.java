package miu.edu.lab4.controller;

import miu.edu.lab4.aspect.annotation.ExecutionTime;
import miu.edu.lab4.entity.Product;
import miu.edu.lab4.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    //@Autowired or use constructor injection
    private final ProductService productService;

    public ProductController(ProductService productService)  {
        this.productService = productService;
    }

    @ExecutionTime
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/add")
    public void addProducts(@RequestBody Product product) {
        productService.addProducts(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int  id) {
        return productService.getProductById(id);
    }

    @GetMapping("/filter")
    public List<Product> filterFields(@RequestParam (required = false) String categoryName, @RequestParam (required = false) Double price, @RequestParam (required = false) String productName) {
        if (categoryName != null && price != null) {
            return productService.getProductsByCategoryNameAndPrice(categoryName, price);
        } else if (categoryName == null && price != null) {
            return productService.getProductsByPriceGreaterThan(price);
        }
        else if (productName != null) {
            return productService.getProductsByNameContaining(productName);
        } else {
            return productService.getProducts();
        }
    }


}
