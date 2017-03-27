package com.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.task.model.Price;
import com.task.model.Product;
import com.task.repositories.PriceRepository;
import com.task.repositories.ProductRepository;

@SpringBootApplication
public class JostensAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JostensAssignmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ProductRepository productRepository, PriceRepository priceRepository) {
		return (args) -> {
			// Persisting initial records for in memory database
			productRepository.save(new Product("B4G5H6", "Trampoline", "Toys", "2017-01-22", new Price(228.90)));
			productRepository.save(new Product("N9M8B7", "Bar stool", "Furniture", "22017-02- 12", new Price(112.89)));
			productRepository.save(new Product("X3C1N8", "Nerf Hoop", "Toys", "2017-03- 01", new Price(22.50)));
		};
	}
}
