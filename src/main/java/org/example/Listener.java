package org.example;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

class Listener{

    private static final Logger logger = LoggerFactory.getLogger(Listener.class);
    private final static String QUEUE_NAME = "messages";
    private static final String HOST = "localhost";

    private ConnectionFactory factory = new ConnectionFactory();;
    private Channel channel;
    private Connection connection = factory.newConnection();

    public Listener() throws IOException, TimeoutException {
        factory.setHost(HOST);
        channel = connection.createChannel();
    }

    public Listener(Channel channel) throws IOException, TimeoutException {
        this.channel = channel;
        factory.setHost(HOST);
    }

    public void listen() throws IOException {
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        logger.info("Listening for messages: ");
        System.out.println("To exit press Ctl + C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            if(MessageParser.validate(message)) {
                String response = MessageParser.createResponse(message);
                System.out.println(response);

            }else{
                logger.error("received invalid message: " + message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}

