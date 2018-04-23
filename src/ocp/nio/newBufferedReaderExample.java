/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PietroS
 */
public class newBufferedReaderExample {

    public static void main(String... s) {
        Path path = Paths.get("/animals/gopher.txt");
        try (BufferedReader reader = Files.newBufferedReader(path,
                Charset.forName("US-ASCII"))) {
// Read from the stream
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
// Handle file I/O exception...
        }
        List<String> data = new ArrayList();
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                Charset.forName("UTF-16"))) {
            writer.write("Hello World");
        } catch (IOException e) {
// Handle file I/O exception...
        }

    }
}
