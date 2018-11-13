package it.sevenbits.basePractice3.reader;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class FileReaderTest {
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();


    @Test
    public void readLine() throws IOException {
        String filename = "File.txt";
        File tmpFile = folder.newFile(filename);
        String fileContainment = "A\nBB\nCCC";
        String expected = String.format("%s 1 A\n%s 2 BB\n%s 3 CCC\n",
                                        filename, filename, filename);

        try (BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(tmpFile))
        )) {
            writer.write(fileContainment);
        }

        FileReader reader = new FileReader(tmpFile);
        StringBuilder sb = new StringBuilder();
        while (reader.hasMoreLines()) {
            sb.append(reader.readLine());
            sb.append('\n');
        }

        assertEquals(expected, sb.toString());
    }
}