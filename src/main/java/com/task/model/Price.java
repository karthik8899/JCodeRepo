package com.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Price {
	
	private Long id;
	private Double amount;
	private Product product;
	
	public Price(){
	}
	
	public Price(Double amount){
		super();
		this.amount = amount;
	}
	
	@Id
	@GeneratedValue(generator="foreigngen")
	@GenericGenerator(name = "foreigngen", strategy = "foreign",
		parameters = @Parameter(name="property", value="product"))
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@OneToOne(mappedBy="price")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
