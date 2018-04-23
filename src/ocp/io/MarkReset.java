/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author PietroS
 */
public class MarkReset {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader("C:\\Users\\pietros\\Source\\Repos\\Java8Programming\\labs\\StudyGuides\\Ocp\\src\\ocp\\io\\zoo-data.txt"))) {
            System.out.print((char) bufferedReader.read());
            if (bufferedReader.markSupported()) {

                bufferedReader.mark(100);
                System.out.print((char) bufferedReader.read());
                System.out.print((char) bufferedReader.read());
                bufferedReader.reset();
                System.out.println("");
                System.out.println("MARK SUPPORTED");
                System.out.println("");
            }
            System.out.print((char) bufferedReader.read());
            System.out.print((char) bufferedReader.read());
            System.out.print((char) bufferedReader.read());

            System.out.print((char) bufferedReader.read());

            System.out.println("");
            System.out.println("SKIP");
            bufferedReader.skip(1);
            bufferedReader.read(); //not printed
            System.out.print((char) bufferedReader.read());
            System.out.print((char) bufferedReader.read());
            System.out.println("");
        }
    }
}
