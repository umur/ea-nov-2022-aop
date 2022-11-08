package com.example.eanov2022aop.service.Impl;


import com.example.eanov2022aop.aspect.annotation.ExecutionTime;
import com.example.eanov2022aop.dto.ProductDto;
import com.example.eanov2022aop.entity.Product;
import com.example.eanov2022aop.mapper.ProductMapper;
import com.example.eanov2022aop.repository.ProductRepo;
import com.example.eanov2022aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    private final ProductMapper productMapper;
    @Transactional
    @Override
    @ExecutionTime
    public List <ProductDto> findAll () {
        return productMapper.toDtos ((List <Product>) productRepo.findAll ());
    }
    @Transactional
    @Override
    @ExecutionTime
    public  ProductDto findProductById (Integer id) {
        return productMapper.toDto (productRepo.findProductById (id));
    }


    @Override
    @Transactional
    public void create (ProductDto productDto) {
        Product product = productMapper.toEntity (productDto);
        productRepo.save (product);
    }

    @Override
    public void delete (Integer id) {
        boolean exists = productRepo.existsById (id);
        if(!exists){
            throw new IllegalStateException ("Product id:"+id+"does not exist");
        }
        productRepo.deleteById (id);

    }

    @Override
    @Transactional
    @ExecutionTime
    public void update(Integer id,String name,double price) {
        Product product = productRepo.findById (id)
                .orElseThrow (()->new IllegalStateException (
                        "Product id:"+id+"does not exist"));

        if(name !=null &&name.length ()>0 ){
            product.setName (name);
        }
        if(price >0){
            product.setPrice (price);
        }
    }
    @Transactional
    @Override
    public List <ProductDto> findProductsByPrice(double minPrice) {
        return productMapper.toDtos (productRepo.findProductsByPriceGreaterThanEqual (minPrice));
    }
    @Transactional
    @Override
    @ExecutionTime
    public List <ProductDto> findByCategory_IdAndPrice (Integer id,double maxPrice) {
        return productMapper.toDtos (productRepo.findByCategory_IdAndPriceLessThanEqual (id,maxPrice));
    }

    @Transactional
    @Override
    @ExecutionTime
    public List <ProductDto> findProductsByNameContains (String keyword) {
        return productMapper.toDtos (productRepo.findProductsByNameContains (keyword));
    }
}
