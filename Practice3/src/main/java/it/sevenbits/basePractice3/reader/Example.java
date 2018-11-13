package it.sevenbits.basePractice3.reader;

import java.io.IOException;

public class Example {
    public int getLongestLineCharsCount(final FileReader reader) throws IOException {
        int result = 0;

        while (reader.hasMoreLines()) {
            String s = reader.readLine();

            if (result < s.length()) {
                result = s.length();
            }
        }

        return result;
    }
}
