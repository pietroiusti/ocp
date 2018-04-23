/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author PietroS
 */
public class ReviewQuestionsNio {

    public static void main(String... s) throws IOException {

        System.out.println("============== 1 ==================");
//1. What is the output of the following code?
//Path path = Path.get("/user/.././root","../kodiacbear.txt");
        Path path = Paths.get("/user/.././root", "../kodiacbear.txt");
        Path path2 = Paths.get("/lion");
//        path.normalize().relativize("/lion");
        path.normalize().relativize(path2);
        System.out.println(path.normalize());    
        System.out.println(path.normalize().relativize(path2));         
        System.out.println(path);
        System.out.println("============== 2 ==================");
//2. For which values of path inserted on the blank line would it be possible for the following
//code to output Success? (Choose all that apply.)
//        Path path2 = Paths.get("C:\\temp");
//        if (Files.isDirectory(path2)) {
////            System.out.println(Files.deleteIfExists(path2) ? "Success" : "Try Again"); //Exception in thread "main" java.nio.file.DirectoryNotEmptyException: C:\temp
//        }

        System.out.println("3. What is the result of executing the following code? (Choose all that apply.");
//3. What is the result of executing the following code? (Choose all that apply.)
        Path path3 = Paths.get("sloth.schedule");

        BasicFileAttributeView attributes = Files.getFileAttributeView(path3, BasicFileAttributeView.class);
        attributes.setTimes(null, null, null);
//        BasicFileAttributes attributes = Files.readAttributes(path3, BasicFileAttributes.class);
//        if (attributes.size() > 0 && attributes.creationTime().toMillis() > 0) {
//            attributes.setTimes(null, null, null);
//        }

        System.out.println(";4. If the current working directory is /user/home, then what is the output of the following code?");
        Path path4 = Paths.get("/zoo/animals/bear/koala/food.txt");
        System.out.println(path4.subpath(1, 3).getName(1).toAbsolutePath());

//5. Assume /kang exists as a symbolic link to the directory /mammal/kangaroo within the file
//system. Which of the following statements are correct about this code snippet? (Choose all
//that apply.)
        System.out.println("============== 5 ==================");

        Path path5 = Paths.get("/kang");
        if (Files.isDirectory(path5) && Files.isSymbolicLink(path5)) {
            Files.createDirectory(path5.resolve("joey"));
        }

//6. Given that /animals is a directory that exists and it is empty, what is the result of the following
//code?
        System.out.println("============== 6 ==================");

        Path path6 = Paths.get("C:\\temp");
        boolean myBoolean = Files.walk(path6)
                //                .filter((p, a) -> a.isDirectory() && !path.equals(p)) // w1
                //                .filter((a) -> a.isDirectory() && !path.equals(a))
                .findFirst().isPresent(); // w2 Exception in thread "main" java.nio.file.NoSuchFileException: \animals
        System.out.println(myBoolean ? "No Sub-directory" : "Has Sub-directory");

        System.out.println("============== 7 ==================");

//7. If the current working directory is /zoo, and the path /zoo/turkey does not exist, then
//what is the result of executing the following code? (Choose all that apply.)
        Path path7 = Paths.get("C:\\temp"); //Exception in thread "main" java.nio.file.NoSuchFileException: turkey
        if (Files.isSameFile(path7, Paths.get("C:\\temp"))) // x1 //Exception in thread "main" java.nio.file.NoSuchFileException: turkey
        {
//            Files.createDirectory(path7.resolve("info")); // x2 //Exception in thread "main" java.nio.file.FileAlreadyExistsException: C:\temp\info
        }

//8. What is the output of the following code?
        System.out.println("============== 8 ==================");
        Path path81 = Paths.get("/pets/../cat.txt");
        Path path82 = Paths.get("./dog.txt");
        System.out.println(path81.resolve(path82));
        System.out.println(path82.resolve(path81));

//13. Assume /monkeys exists as a regular directory containing multiple files, symbolic links,
//and subdirectories. What is true about the following code? (Choose all that apply.)
        System.out.println("============== 13 ==================");
//        Path path13 = Paths.get("/monkeys"); //Exception in thread "main" java.nio.file.NoSuchFileException: \monkeys
//        Files.find(path13, 0, (p, a) -> a.isSymbolicLink()).map(p -> p.toString()) // y1
//                .collect(Collectors.toList()) // y2
//                .stream() // y3
//                .filter(x -> x.toString().endsWith(".txt")) // y4
//                .forEach(System.out::println);

//16. Assuming /squid/food-schedule.csv exists as a regular non-empty file that a program
//has access to read, what is correct about the following code snippet? (Choose all that apply.)
        System.out.println("============== 16 ==================");
//        Path path16 = Paths.get("/squid/food-schedule.csv");
//        Files.lines(path16) // r1
//                .flatMap(p -> Stream.of(p.split(","))) // r2
//                .map(t -> t.toUpperCase()) // r3
//                .forEach(System.out::println);

        System.out.println("============== 17 ==================");
//17. Assuming the current directory is /animals/cute, which are possible results of executing
//the following code? (Choose all that apply.)
//        Files.walk(Paths.get("..").toRealPath().getParent()) // u1
//                .map(p -> p.toAbsolutePath().toString()) // u2
//                .filter(s17 -> s17.endsWith(".java")) // u3
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        System.out.println("============== 18 ==================");
//18. Assuming the directories and files referenced here all exist and are accessible within the file
//system, what is the result of the following code?
        Path path118 = Paths.get("/temp/./").resolve(Paths.get("walking.txt"));
        Path path218 = new File("/temp/././actions/../walking.txt").toPath();
//        Path path118 = Paths.get("C:\\temp\\.\\").resolve(Paths.get("walking.txt"));
//        Path path218 = new File("C:\\temp\\.\\.\\actions\\..\\walking.txt").toPath();   
        System.out.println("path118: \t\t\t" + path118);
        System.out.println("normalize path118: \t\t\t" + path118.normalize());
        System.out.println("relativize path118 -> path218: \t\t\t" + path118.relativize(path218));          
        System.out.println("path218: \t\t\t" + path218);
        System.out.println("normalize path218: \t\t\t" + path218.normalize());
        System.out.println("relativize path218 -> path118: \t\t\t" + path218.relativize(path118));             
        System.out.print(Files.isSameFile(path118, path218));
        System.out.print(" " + path118.equals(path218));
        System.out.println(" " + path118.normalize().equals(path218.normalize()));
//D. true false true

//20. Assuming the current directory is /seals/harp/food, what is the result of executing the
//following code?
        System.out.println("============== 20 ==================");
        final Path path20 = Paths.get(".\\.\\.\\temp\\count\\").normalize(); // h1
        System.out.println("path20: \t\t\t" + path20);
                System.out.println("path20 name count : \t\t\t" + path20.getNameCount());
        int count = 0;
        for (int i = 0; i < path20.getNameCount(); ++i) {
            count++;
        }
        System.out.println(count);
    }
}
