package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageParserTest {
    @Test
    public void testResponseMessage() {
        System.out.println("createResponse method");
        String message = "Hello my name is, Donald Trump";
        String response = MessageParser.createResponse(message);
        String result = "Hello Donald Trump, I am your father!";
        assertEquals(result,response);
    }

    @Test
    public void validateShouldAnswerWithFalse(){
        System.out.println("validate message method");
        String message = "Helloo there";
        assertFalse(MessageParser.validate(message));
    }

    @Test
    public void validateShouldAnswerWithTrue(){
        System.out.println("validate message method");
        String message = "Hello my name is, Donald";
        assertTrue(MessageParser.validate(message));
    }
}
