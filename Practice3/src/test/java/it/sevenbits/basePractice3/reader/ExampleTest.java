package it.sevenbits.basePractice3.reader;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExampleTest {

    @Test
    public void testSameLength() throws IOException {
        FileReader mockReader = mock(FileReader.class);
        when(mockReader.hasMoreLines()).thenReturn(true, true, true, true, false);
        when(mockReader.readLine()).thenReturn(
            "File.txt 1 first line",
            "File.txt 2 second line",
            "File.txt 3 third line",
            "File.txt 4 fourth line",
            null
        );

        Example example = new Example();
        assertEquals(22, example.getLongestLineCharsCount(mockReader));
    }

    @Test
    public void testEmptyFile() throws IOException {
        FileReader mockReader = mock(FileReader.class);
        when(mockReader.hasMoreLines()).thenReturn(false);
        when(mockReader.readLine()).thenReturn(null);

        Example example = new Example();
        assertEquals(0, example.getLongestLineCharsCount(mockReader));
    }
}