package com.juiceman.StupideBench;

import com.juiceman.StupideBench.model.Categories;
import com.juiceman.StupideBench.model.Products;
import com.juiceman.StupideBench.model.UsersRepository;
import com.juiceman.StupideBench.repository.CategoryRepository;
import com.juiceman.StupideBench.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StupideBenchApplication implements CommandLineRunner {


	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(StupideBenchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		usersRepository.updateName("firstName","Tim","Tim_1");

		for(Products products:productRepository.findAll()){
			System.out.println(products);
		}

		for(Categories category:categoryRepository.findAll()){
			System.out.println(category);
		}

	}
}

