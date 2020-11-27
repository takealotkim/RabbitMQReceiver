package org.example;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * listen for messages from Rabbit MQ
 * and print response
 */
public class App 
{
    public static void main( String[] args ) throws IOException, TimeoutException {

        Listener listener = new Listener();
        listener.listen();
    }
}
