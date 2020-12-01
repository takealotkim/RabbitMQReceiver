package org.example;

import com.rabbitmq.client.Channel;
import org.junit.Test;

import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    private Channel channel = Mockito.mock(Channel.class);
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }




}
