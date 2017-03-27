package com.task.dto;

public class ProductPriceDto {
	
	private Long id;
	private String sku;
	private String name;
	private String category;
	private String lastUpdatedTmstp;
	private Double amount;
	
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
