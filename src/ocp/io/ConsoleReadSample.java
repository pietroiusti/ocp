/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.io;

/**
 *
 * @author PietroS
 */
import java.io.*;

public class ConsoleReadSample {

    public static void main(String[] args) throws NumberFormatException
//            , IOException 
    {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            console.writer().print("How excited are you about your trip today? ");
            console.flush();
            String excitementAnswer = console.readLine();
            String name = console.readLine("Please enter your name: ");
Integer age = null;
            console.writer().print("What is your age? ");
            console.flush();
//            BufferedReader reader = new BufferedReader(console.reader());
//            String value = reader.readLine();
//            age = Integer.valueOf(value);
            console.writer().println();
            console.format("Your name is " + name);
            console.writer().println();
            console.format("Your age is " + age);
            console.printf("Your excitement level is: " + excitementAnswer);
        }
    }
}
