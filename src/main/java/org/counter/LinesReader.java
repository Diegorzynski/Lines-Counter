package org.counter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LinesReader {

    private static int sumOfLines;
    public static void readFolder(String folderPath) throws IOException {
        try(Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
            paths.filter(Files::isRegularFile)
                    .forEach(LinesReader::countLines);
        }
        System.out.println("Total sum of lines: " + getSumOfLines());
    }

    private static void countLines(Path path){
       int numberOfLines = 0;
       LineNumberReader reader = null;
       try {
           reader = new LineNumberReader(new FileReader(path.toFile()));
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
       while(true){
           try {
               if ((reader.readLine()) == null) break;
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           numberOfLines ++;
       }
       addLine(numberOfLines);
       System.out.println(path + " -> " + numberOfLines);
   }

      private static void addLine(int lineCount){
       sumOfLines += lineCount;
   }

    private static int getSumOfLines() {
        return sumOfLines;
    }

}
