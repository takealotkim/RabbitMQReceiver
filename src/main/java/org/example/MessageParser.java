package org.example;

public class MessageParser {

    public static boolean validate(String message){
        return message.contains("Hello my name is, ");
    }

    public static String createResponse(String message){
        String name = message.replace("Hello my name is, ", "");
        return "Hello " + name + ", I am your father!";
    }
}
