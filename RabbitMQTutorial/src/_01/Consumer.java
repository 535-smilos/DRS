package _01;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {
	
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws Exception{
	
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();//ovo dvoje ne ide u try jer konekcije stalno moraju biti otvorene ako misli da primi poruke
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	    
	    DeliverCallback deliverCallback = (consumerTag, delivery) -> {//anonimna fja koja se pokrece kad nova poruka dodje
	        String message = new String(delivery.getBody(), "UTF-8");
	        System.out.println(" [x] Received '" + message + "'");//stampanje sadrzaja poruke
	    };
	    channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

	}
}
