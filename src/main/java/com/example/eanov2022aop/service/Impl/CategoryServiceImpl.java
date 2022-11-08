package com.example.eanov2022aop.service.Impl;


import com.example.eanov2022aop.dto.CategoryDto;
import com.example.eanov2022aop.entity.Category;
import com.example.eanov2022aop.mapper.CategoryMapper;
import com.example.eanov2022aop.repository.CategoryRepo;
import com.example.eanov2022aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;
    @Transactional
    @Override
    public List <CategoryDto> findAll () {
        return categoryMapper.toDtos ((List <Category>) categoryRepo.findAll ());
    }
    @Transactional
    @Override
    public  CategoryDto findCategoryById (Integer id) {
        return categoryMapper.toDto (categoryRepo.findCategoryById(id));
    }

    @Transactional
    @Override
    public void create (CategoryDto categoryDto) {
        categoryRepo.save (categoryMapper.toEntity (categoryDto));

    }

    @Override
    public void delete (Integer id) {
        boolean exists = categoryRepo.existsById (id);
        if(!exists){
            throw new IllegalStateException ("Product id:"+id+"does not exist");
        }
        categoryRepo.deleteById (id);

    }

    @Override
    @Transactional
    public void update(Integer id,String name) {
        Category product = categoryRepo.findById (id)
                .orElseThrow (()->new IllegalStateException (
                        "Product id:"+id+"does not exist"));

        if(name !=null &&name.length ()>0 ){
            product.setName (name);
        }
    }
}
