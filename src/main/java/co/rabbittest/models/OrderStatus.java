package co.rabbittest.models;

public class OrderStatus {

	private Order order;
	private String status;
	private String message;
	
	public OrderStatus() {
		
	}
	
	public OrderStatus(Order order, String status, String message) {
		this.order = order;
		this.status = status;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Order=" + order + " | Status=" + status + " | Message=" + message;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setOrder(Order o) {
		order = o;
	}
	
	public void setStatus(String s) {
		status = s;
	}
	
	public void setMessage(String s) {
		message = s;
	}
	
}
