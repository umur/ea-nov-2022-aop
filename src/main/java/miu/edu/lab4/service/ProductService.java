package miu.edu.lab4.service;

import miu.edu.lab4.entity.Product;
import miu.edu.lab4.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;



    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getProductsByCategoryNameAndPrice(String categoryName, Double price) {
        return productRepo.findByCategoryNameAndPriceGreaterThan(categoryName, price);
    }

    public List<Product> getProductsByNameContaining(String name) {
        return productRepo.findByNameContaining(name);
    }

    public List<Product> getProductsByPriceGreaterThan(double minPrice) {
        return productRepo.findProductsByPriceGreaterThan(minPrice);
    }


    public void addProducts( Product product) {
        productRepo.save(product);
    }

    public  List<Product> getProducts() {
        return (List<Product>) productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).get();
    }
}
