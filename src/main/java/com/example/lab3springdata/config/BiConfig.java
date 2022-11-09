package com.example.lab3springdata.config;


import com.example.lab3springdata.model.uni_directional.Category;
import com.example.lab3springdata.model.uni_directional.Product;
import com.example.lab3springdata.model.uni_directional.Rating;
import com.example.lab3springdata.repo.CategoryRepository;
import com.example.lab3springdata.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnProperty(prefix = "db.bi", value = "active")
public class BiConfig {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;




    public BiConfig(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hey");
            Category healthCat = new Category("Health");
            Category animalCat = new Category("Animal new");
            Category electronicsCat = new Category("Electronics");
            List<Category> categories = new ArrayList<Category>() {{
                add(healthCat);
                add(animalCat);
                add(electronicsCat);
            }};
//            categoryRepository.saveAll(categories);

            Product catFood = new Product("cat food9", 2.65, Rating.GOOD);
//            productRepository.save(catFood);
//            Product savedProduct = productRepository.save(coconutOil);
//            savedProduct.setName("oil only");
//            productRepository.save(savedProduct);

//            categoryRepository.findAll().forEach(System.out::println);

//
//            Optional<Product> prodById = productRepository.findById(4);
//            prodById.get().setName("oil only");
//            productRepository.save(prodById.get());

//            save(catFood);

//            System.out.println(prodById.get());

//            productRepository.deleteAllById(
//                    IntStream.
//                    iterate(44, a -> a+4).
//                    limit(2)
//                            .boxed()
//                            .collect(Collectors.toList())
//            );

//            productRepository.delete(catFood);

//            productRepository.findAllByCategory(animalCat).forEach(System.out::println);
//            productRepository.findAllByCategoryId(79).forEach(System.out::println);
//
//            System.out.println("Start Checking Email Repo");
//            emailRepo.findAllByEmployeeqId(10L).forEach(System.out::println);
//
//
//            System.out.println("Start checking Employee Repo");
//            employeeRepo.findAllByEmailsId(1L).forEach(System.out::println);

        };
    }

//    private static Connection con;
//
//    static {
//        try {
//            con = DriverManager.getConnection("jdbc://etc..");
////            String s = con.nativeSQL("select * from   ");
//            Statement statement = con.createStatement();
//            boolean execute = statement.execute("");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    @Transactional
//    public Optional<Product> findAndPrint(ProductRepository productRepository,int id) {
////        productRepository.findById(id).ifPresent(System.out::println);
//        Optional<Product> prodById = productRepository.findById(id);
//        prodById.ifPresent(System.out::println);
//        return prodById;
//    }


    @Transactional
    public void save(Product p) {
        productRepository.save(p);
        p.setName("3alaf!");
    }

}
