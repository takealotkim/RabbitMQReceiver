package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitMQConfiguration {
    private Logger logger = LoggerFactory.getLogger(RabbitMQConfiguration.class);
    private String queueName = "messages";
    private String host = "localhost";

    public RabbitMQConfiguration(){
    }

    public RabbitMQConfiguration(String host, String queueName){
        this.host = host;
        this.queueName = queueName;
    }

    public String getHost(){
        return this.host;
    }
    public String getQueueName(){
        return this.queueName;
    }
}
