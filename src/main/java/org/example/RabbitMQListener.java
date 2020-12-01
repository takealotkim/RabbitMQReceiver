package org.example;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

class RabbitMQListener {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);

    private RabbitMQConfiguration configuration = new RabbitMQConfiguration();
    private ConnectionFactory factory = new ConnectionFactory();;
    private Connection connection;
    private Channel channel;
    private DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String message = new String(delivery.getBody(), "UTF-8");
        if(MessageParser.validate(message)) {
            String response = MessageParser.createResponse(message);
            System.out.println(response);

        }else{
            logger.error("received invalid message: " + message);
        }
    };

    public RabbitMQListener() throws IOException, TimeoutException {
        init();
    }

    public RabbitMQListener(RabbitMQConfiguration configuration) throws IOException, TimeoutException {
        this.configuration = configuration;
        init();
    }

    public void init() throws IOException, TimeoutException {
        factory.setHost(configuration.getHost());
        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public RabbitMQListener(Channel channel) throws IOException, TimeoutException {
        this.channel = channel;
    }

    public void listen() throws IOException {
        channel.queueDeclare(configuration.getQueueName(), false, false, false, null);
        logger.info("Listening for messages: ");
        channel.basicConsume(configuration.getQueueName(), true, this.deliverCallback, consumerTag -> { });
    }
}

