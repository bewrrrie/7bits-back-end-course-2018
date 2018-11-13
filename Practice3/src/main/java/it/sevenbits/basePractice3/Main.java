package it.sevenbits.basePractice3;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File inFile = new File("Homework3.txt");
        File outFile = new File("MyHomework.txt");
        boolean status = outFile.createNewFile();
        String secondName = "Лешков";

        try (FileInputStream in = new FileInputStream(inFile);
             FileOutputStream out = new FileOutputStream(outFile)) {
            out.write(IOUtils.toByteArray(in));
            out.write(secondName.getBytes());
        }
    }
}
