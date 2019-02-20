package com.juiceman.StupideBench;

import com.juiceman.StupideBench.model.*;
import com.juiceman.StupideBench.repository.*;
import com.juiceman.StupideBench.service.OrdersHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StupideBenchApplication implements CommandLineRunner {


	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private OrdersHistoryService ordersHistoryService;

	public static void main(String[] args) {
		SpringApplication.run(StupideBenchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//usersRepository.updateName("firstName","Tim","Tim_1");

		/*
		for(Products products:productRepository.findAll()){
			System.out.println(products);
		}

		for(Categories category:categoryRepository.findAll()){
			System.out.println(category);
		}

		for(Person person:personRepository.findAll()){
			System.out.println(person);
		}
*/

        /*
		Inventory pStorage = new Inventory();
		pStorage.setProductId("4c4b1476238d3b4dd5003982");
		pStorage.setAmount(5);
		pStorage.setName("MacBook Air 2018");
		inventoryRepository.save(pStorage);
        */
		/*
        String usernameOrEmail = "rrrr";
		Person p = personRepository.findByUserNameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow(
				()->new UsernameNotFoundException("User not found with username or email : ")

		);
		System.out.println("find by usernameOrEmail:"+p);
        */

		/*
	    List<Orders> ordersList = ordersHistoryService.getOrdersByUserId("5c4d606ee9970564af66ce9e");
		for(Orders order:ordersList){
			System.out.println(order.getId());
		}
        */

	}
}

