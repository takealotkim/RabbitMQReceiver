package org.example;

import com.rabbitmq.client.Channel;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class RabbitMQListenerTest {
    private Channel channel = Mockito.mock(Channel.class);
    private RabbitMQListener listener;

    @Test
    public void receiveErrors() {
        Exception exception=null;
        try {
            listener = new RabbitMQListener(channel);
            listener.listen();
        }catch(Exception ex){
            exception=ex;
        }
        assertTrue(exception == null);
    }








}
