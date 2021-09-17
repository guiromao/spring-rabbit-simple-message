package co.rabbittest.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import co.rabbittest.commons.Commons;
import co.rabbittest.models.OrderStatus;

@Component
public class Consumer {
	
	@RabbitListener(queues = Commons.QUEUE_NAME)
	public void consume(OrderStatus orderStatus) {
		System.out.println(orderStatus);
	}

}
