package com.task.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {
	
	private Long id;
	private String sku;
	private String name;
	private String category;
	private String lastUpdatedTmstp;
	private Price price;
	
	public Product(){
	}
	
	public Product(String sku, String name, String category, String lastUpdatedTmstp, Price price){
		super();
		this.sku = sku;
		this.name = name;
		this.category = category;
		this.lastUpdatedTmstp = lastUpdatedTmstp;
		this.price = price;
		this.price.setProduct(this);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_GEN")
	@SequenceGenerator(name="SEQ_GEN", initialValue=100, allocationSize=1)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLastUpdatedTmstp() {
		return lastUpdatedTmstp;
	}
	public void setLastUpdatedTmstp(String lastUpdatedTmstp) {
		this.lastUpdatedTmstp = lastUpdatedTmstp;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}

}
