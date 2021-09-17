package co.rabbittest.controllers;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.rabbittest.commons.Commons;
import co.rabbittest.models.Order;
import co.rabbittest.models.OrderStatus;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("/{restaurantId}")
	public ResponseEntity postOrder(@PathVariable Integer restaurantId, @RequestBody Order order) {
		order.setId(UUID.randomUUID());
		OrderStatus orderStatus = new OrderStatus(order, "Order in Progress", "Successfully received the order!");
		//business logic here
		rabbitTemplate.convertAndSend(Commons.EXCHANGE_NAME, Commons.ROUTING_KEY_NAME, orderStatus);
		
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
