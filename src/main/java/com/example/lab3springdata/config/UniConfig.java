package com.example.lab3springdata.config;


import com.example.lab3springdata.model.uni_directional.Category;
import com.example.lab3springdata.repo.CategoryRepository;
import com.example.lab3springdata.repo.ProductRepository;
import com.example.lab3springdata.repo.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@ConditionalOnProperty(prefix = "db.uni", value = "active")
public class UniConfig {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final ReviewRepository reviewRepository;

    public UniConfig(CategoryRepository categoryRepository, ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hey from heree!!");
//            Category healthCat = new Category("Health");
//            Category animalCat = new Category("Animal new");
//            Category electronicsCat = new Category("Electronics");
//            List<Category> categories = new ArrayList<Category>() {{
//                add(healthCat);
//                add(animalCat);
//                add(electronicsCat);
//            }};

            Optional<Category> categoryOne = categoryRepository.findById(1);

//            productRepository.findAllByCategoryId(1).forEach(System.out::println);
//
//            System.out.println("check this one");
//

            //case1 testing

            productRepository.findAllByCategory_NameAndPriceIsLessThan("cat", 25).forEach(System.out::println);


            productRepository.findAllByCategory_NameAndPriceIsLessThan("cat", 26).forEach(System.out::println);

            productRepository.findAllByCategory_NameAndPriceIsLessThan("cat", 21).forEach(System.out::println);

            //case2 testing

            productRepository.findAllByPriceGreaterThan(15).forEach(System.out::println);

            // cas3 testing

            productRepository.findAllByNameContaining("keyword").forEach(System.out::println);

            productRepository.findAllByNameContaining("bat").forEach(System.out::println);

            // case 4 testing
//            reviewRepository.findAllByProduct_Id(4).forEach(System.out::println);




        };

    }
}
