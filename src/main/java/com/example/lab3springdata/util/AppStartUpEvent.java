package com.example.lab3springdata.util;

import com.example.lab3springdata.amigos.Student;
import com.example.lab3springdata.repo.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;


//@Component
public class AppStartUpEvent implements ApplicationContextAware, SmartLifecycle {


    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final AddressRepository addressRepository;


    public AppStartUpEvent( UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository, ReviewRepository reviewRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
        this.addressRepository = addressRepository;
    }


//    @PostConstruct
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        StreamSupport.
//                stream(userRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//
//        StreamSupport.
//                stream(productRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//
//        StreamSupport.
//                stream(categoryRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//
//        StreamSupport.
//                stream(reviewRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//
//        StreamSupport.
//                stream(addressRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void start() {

//        productRepository.findAllByCategoryId(1)
//                .forEach(System.out::println);

//        StreamSupport.
//                stream(productRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//
//        StreamSupport.
//                stream(categoryRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//
//        StreamSupport.
//                stream(reviewRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//
//        StreamSupport.
//                stream(addressRepository.findAll().spliterator(), false)
//                .limit(20)
//                .forEach(System.out::println);
//

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
