package it.sevenbits.basePractice3.reader;

import java.io.*;

public class FileReader implements Closeable {
    private BufferedReader reader;
    private String fileName;
    private String lastLine;
    private int lineCount;

    private FileReader() {}

    public FileReader(final File file) throws IOException {
        reader = new BufferedReader(new InputStreamReader(
            new FileInputStream(file)
        ));

        fileName = file.getName();
        lastLine = reader.readLine();
        lineCount = 1;
    }

    public String readLine() throws IOException {
        if (lastLine != null) {
            StringBuilder sb = new StringBuilder()
            .append(fileName)
            .append(' ')
            .append(lineCount)
            .append(' ')
            .append(lastLine);

            lastLine = reader.readLine();
            lineCount++;

            return sb.toString();
        }

        return null;
    }

    public boolean hasMoreLines() {
        return lastLine != null;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
