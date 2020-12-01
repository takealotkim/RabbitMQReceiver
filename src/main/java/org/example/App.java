package org.example;

import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * listen for messages from Rabbit MQ
 * and print response
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);

    public static void main( String[] args ) throws IOException, TimeoutException {

        RabbitMQConfiguration configuration = new RabbitMQConfiguration();
        RabbitMQListener rabbitMQListener = new RabbitMQListener(configuration);
        System.out.println("To exit press Ctl + C");
        rabbitMQListener.listen();
    }
}
