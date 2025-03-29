package com.ecom.prod.catalog.config;

import com.ecom.prod.catalog.model.Category;
import com.ecom.prod.catalog.model.Product;
import com.ecom.prod.catalog.repository.CategoryRepository;
import com.ecom.prod.catalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
    public class DataSeeder implements CommandLineRunner {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //clear all existing data

        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //Create Categories

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));

        //Create Products

        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("It is a very affordable phone");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("The laptop has a very high processing speed");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("A ver warm and cosy jacket");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(99.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("Blenders work as twice as better as the others in the country");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(199.99);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone,laptop, jacket, blender));
    }
}
