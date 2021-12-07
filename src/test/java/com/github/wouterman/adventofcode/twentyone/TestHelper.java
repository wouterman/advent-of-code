package com.github.wouterman.adventofcode.twentyone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static String[] getFromInputFile(String inputFile) throws IOException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(inputFile);
        if (is == null) {
            throw new IllegalArgumentException("Could not find inputfile: " + inputFile);
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[0]);
    }

}
