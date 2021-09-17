package co.rabbittest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.rabbittest.commons.Commons;

@Configuration
public class MessageConfig {
	
	@Bean
	public Queue queue() {
		return new Queue(Commons.QUEUE_NAME);
	}
	
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(Commons.EXCHANGE_NAME);
	}

	
	@Bean
	public Binding bind(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Commons.ROUTING_KEY_NAME);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		
		return rabbitTemplate;
	}

}
