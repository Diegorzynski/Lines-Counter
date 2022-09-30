package org.counter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String File_Path = "src/main/resources/files";

        LinesReader.readFolder(File_Path);

    }
}