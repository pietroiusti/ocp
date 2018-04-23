/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author PietroS
 */
public class Attributesexamples {

    public static void main(String... sargs) throws IOException {

        try {
            final Path path = Paths.get("/rabbit/food.jpg");
            System.out.println(Files.getLastModifiedTime(path).toMillis());
            Files.setLastModifiedTime(path,
                    FileTime.fromMillis(System.currentTimeMillis()));
            System.out.println(Files.getLastModifiedTime(path).toMillis());
        } catch (IOException e) {
// Handle file I/O exception...
        }

//Managing Ownership with getOwner() and setOwner()
        try {
// Read owner of file
            Path path = Paths.get("/Temp/walking.txt");
            System.out.println(Files.getOwner(path).getName());
// Change owner of file
            UserPrincipal owner = path.getFileSystem()
                    .getUserPrincipalLookupService().lookupPrincipalByName("pietros");
            Files.setOwner(path, owner);
// Output the updated owner information
            System.out.println(Files.getOwner(path).getName());
        } catch (IOException e) {
// Handle file I/O exception...
        }

//Reading Attributes     
        try {
            Path path = Paths.get("/Temp/walking.txt");
            BasicFileAttributes data = Files.readAttributes(path,
                    BasicFileAttributes.class);
            System.out.println("Is path a directory? " + data.isDirectory());
            System.out.println("Is path a regular file? " + data.isRegularFile());
            System.out.println("Is path a symbolic link? " + data.isSymbolicLink());
            System.out.println("Path not a file, directory, nor symbolic link? "
                    + data.isOther());
            System.out.println("Size (in bytes): " + data.size());
            System.out.println("Creation date/time: " + data.creationTime());
            System.out.println("Last modified date/time: " + data.lastModifiedTime());
            System.out.println("Last accessed date/time: " + data.lastAccessTime());
            System.out.println("Unique file identifier (if available): "
                    + data.fileKey());
        } catch (IOException e) {
// Handle file I/O exception...
        }

//Modifying Attributes
        try {
            Path path = Paths.get("/Temp/walking.txt");
            BasicFileAttributeView view
                    = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            BasicFileAttributes data = view.readAttributes();
            FileTime lastModifiedTime = FileTime.fromMillis(
                    data.lastModifiedTime().toMillis() + 10_000);
            view.setTimes(lastModifiedTime, null, null);
        } catch (IOException e) {
// Handle file I/O exception...
        }

//Walking a Directory
        try {
            Path path = Paths.get("/bigcats");
            Files.walk(path)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
// Handle file I/O exception...
        }

//Searching a Directory
        try {
            Path path = Paths.get("/bigcats");
            long dateFilter = 1420070400000l;
            Stream<Path> stream = Files.find(path, 10,
                    (p, a) -> p.toString().endsWith(".java")
                    && a.lastModifiedTime().toMillis() > dateFilter);
            stream.forEach(System.out::println);
        } catch (Exception e) {
// Handle file I/O exception...
        }

//Listing Directory Contents
        try {
            Path path = Paths.get("ducks");
            Files.list(path)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toAbsolutePath())
                    .forEach(System.out::println);
        } catch (IOException e) {
// Handle file I/O exception...
        }

//Printing File Contents
        try {
            Path path = Paths.get("/fish/sharks.log");
            System.out.println(Files.lines(path)
                    .filter(s -> s.startsWith("WARN "))
                    .map(s -> s.substring(5))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
// Handle file I/O exception...
        }
    }

}
