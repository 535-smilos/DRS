package _01;


import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public class Producer {
	
	private final static String QUEUE_NAME="hello";
	
	public static void main(String[] args) {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("guest");
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {
			
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "DRS RabbitMQ!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());//fja za slanje poruke na rmq server
			System.out.println(" [x] Sent '" + message + "'");
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
		
	}
}
