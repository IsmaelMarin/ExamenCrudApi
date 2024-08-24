package com.examen.e_commerce;

import com.examen.e_commerce.model.*;
import com.examen.e_commerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	DeliveryRepository deliveryRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

												//Agregaciones
		//Tabla Clientes

		/*

		Customer customer = new Customer();
		customer.setName("Pablo Motos");
		customer.setEmail("pabloMotos@gmail.com");
		customer.setAddress("Madrid España");
		customerRepository.save(customer);
		System.out.println(customer);


		//Tabla Entregar
		Delivery delivery = new Delivery();
		delivery.setType(Delivery.DeliveryType.FISICAS);
		delivery.setStatus(Delivery.DeliveryStatus.ENTREGADO);
		deliveryRepository.save(delivery);
		System.out.println(delivery);


		//Tabla categorias
		Category category = new Category();
		category.setCategoryName("Smartphones");
		category.setCategoryType(Category.CategoryType.ELECTRONICA);
		categoryRepository.save(category); //Guardamos la categoria en la base de datos
		System.out.println(category);

		//Tabla Productos
		Product productos = new Product();
		productos.setProductName("Smartphone");
		productos.setCategory(category);
		productRepository.save(productos);
		System.out.println(productos);

		//Tabla Orden
		Order orden=new Order();
		orden.setOrderDate(new Date());
		orden.setDelivery(delivery);
		orden.setCustomer(customer);
		orderRepository.save(orden);
		System.out.println(orden);


		 */




	}
}
