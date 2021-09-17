package co.rabbittest.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Order {
	
	private UUID id;
	private String item;
	private Integer quantity;
	private Double price;
	
	public Order() {
		
	}
	
	public Order(UUID id, String item, Integer quantity, Double price) {
		this.id = id;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "{UUID=" + id + " | Item=" + item + " | Quantity=" + quantity + 
				" | Price=" + price + "}";
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getItem() {
		return item;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setId(UUID uuid) {
		id = uuid;
	}
	
	public void setItem(String s) {
		item = s;
	}
	
	public void setQuantity(Integer i) {
		quantity = i;
	}
	
	public void setPrice(Double d) {
		price = d;
	}

}
