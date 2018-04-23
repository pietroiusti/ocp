/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author PietroS
 */
public class ReviewQuestionsIo {

    public static void main(String... args) throws IOException {

        try (
                BufferedReader in = new BufferedReader(
                        new FileReader("C:\\Users\\pietros\\Source\\Repos\\Java8Programming\\labs\\StudyGuides\\Ocp\\src\\ocp\\io\\zoo-data.txt"))) {

//            System.out.print((char) in.read());
//            if (in.markSupported()) {
//                in.mark(100);
//                System.out.print((char) in.read());
//                System.out.print((char) in.read());
//                in.reset();
//            }
//            System.out.print((char) in.read());
//            System.out.print((char) in.read());
//            System.out.print((char) in.read());
//
//            System.out.print((char) in.read());
//            in.skip(2);
//            in.read();
//            System.out.print((char) in.read());
//            System.out.print((char) in.read());
//23. Assume that you have an InputStream whose next bytes are XYZABC. What is the result of
//calling the following method on the stream, using a count value of 3?
//public static String pullBytes(InputStream is, int count) throws IOException
            int count = 30;
            if (in.markSupported()) {
                in.mark(7);
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sb.append((char) in.read());
                }
                System.out.println(sb.toString());
                in.reset();
                in.skip(1);
                sb.append((char) in.read());
                sb.append((char) in.read());                
//                for (int i = 0; i < count; i++) {
//                    sb.append((char) in.read());
//                }                
                System.out.println(sb.toString());
            }
//            int b;
//            while ((b = in.read()) != -1) {
//                out.write(b);
//            }

        }

    }
}
