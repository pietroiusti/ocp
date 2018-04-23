/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.nio;
/**
 *
 * @author PietroS
 */
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathFilePathTest {

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null) {
            System.out.println(" Current parent is: " + currentParent);
        }
    }

    public static void main(String[] args) {
        printPathInformation(Paths.get("/zoo/armadillo/shells.txt"));
        System.out.println();
        printPathInformation(Paths.get("armadillo/shells.txt"));
//Checking Path Type with isAbsolute() and toAbsolutePath()
        Path path1 = Paths.get("C:\\birds\\egret.txt");
        System.out.println("Path1 is Absolute? " + path1.isAbsolute());
        System.out.println("Absolute Path1: " + path1.toAbsolutePath());
        Path path2 = Paths.get("birds/condor.txt");
        System.out.println("Path2 is Absolute? " + path2.isAbsolute());
        System.out.println("Absolute Path2 " + path2.toAbsolutePath());
        System.out.println(Paths.get("/stripes/zebra.exe").isAbsolute());
        System.out.println(Paths.get("c:/goats/Food.java").isAbsolute());
//Creating a New Path with subpath()     
        System.out.println("Subpath from 0 to 3 is: " + path1.subpath(0, 3));
//Deriving a Path with relativize()
        System.out.println(path1.relativize(path2));
//Joining Path Objects with resolve()  
        final Path path3 = Paths.get("/cats/../panther");
        final Path path4 = Paths.get("food");
        System.out.println(path3.resolve(path4));

//Searching a directory
        Path path = Paths.get("/bigcats");
        long dateFilter = 1420070400000l;
        try {
            Stream<Path> stream = Files.find(path, 10,
                    (p, a) -> p.toString().endsWith(".java")
                    && a.lastModifiedTime().toMillis() > dateFilter);
            stream.forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
//Listing directory contents
        try {
            Path pathdl = Paths.get("ducks");
            Files.list(pathdl)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toAbsolutePath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
//Printing File Contents
        Path pathpfc = Paths.get("/fish/sharks.log");
        try {
            Files.lines(pathpfc).forEach(System.out::println);
        } catch (IOException e) {
// Handle file I/O exception...
        }
        Path pathpfc2 = Paths.get("/fish/sharks.log");
        try {
            System.out.println(Files.lines(pathpfc2)
                    .filter(s -> s.startsWith("WARN "))
                    .map(s -> s.substring(5))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
// Handle file I/O exception...
        }
    }
}
