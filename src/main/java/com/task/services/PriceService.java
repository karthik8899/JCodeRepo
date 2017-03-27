package com.task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.model.Price;
import com.task.repositories.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	public List<Price> getPriceRecords(){
		//TODO create and use Price DTO
		List<Price> prices = (List<Price>) priceRepository.findAll(); 
		return prices;
	}
	
	public Price getPrice(Long id){
		return priceRepository.findOne(id);
	}
	
	public void saveOrUpdatePrice(Price price){
		priceRepository.save(price);
	}
	
	public void deletePrice(Long id){
		priceRepository.delete(id);
	}
	
}