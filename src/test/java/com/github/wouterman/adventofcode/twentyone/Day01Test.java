package com.github.wouterman.adventofcode.twentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {

    private Day01 day01;

    @BeforeEach
    void init() {
        day01 = new Day01();
    }

    @ParameterizedTest
    @MethodSource("day01input")
    void solution(String[] measurements, int expected) {
        int result = day01.solution(measurements);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> day01input() throws IOException {
        return Stream.of(
                Arguments.of(new String[]{"200", "199"}, 0),
                Arguments.of(new String[]{"199", "200"}, 1),
                Arguments.of(new String[]{"199", "200", "201"}, 2),
                Arguments.of(new String[]{"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"}, 7),
                Arguments.of(getFromInputFile(), 1477)
        );
    }

    @ParameterizedTest
    @MethodSource("day01pt2input")
    void solution2(String[] measurements, int expected) {
        int result = day01.solution2(measurements);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> day01pt2input() throws IOException {
        return Stream.of(
                Arguments.of(new String[0], 0),
                Arguments.of(new String[]{"200", "199"}, 0),
                Arguments.of(new String[]{"199", "200"}, 0),
                Arguments.of(new String[]{"199", "200", "201", "202" }, 1),
                Arguments.of(new String[]{"199", "200", "201", "202", "203" }, 2),
                Arguments.of(new String[]{"199", "200", "208", "210", "200" }, 1),
                Arguments.of(new String[]{"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"}, 5),
                Arguments.of(getFromInputFile(), 1523)
        );
    }

    private static String[] getFromInputFile() throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        ClassLoader.getSystemClassLoader().getResourceAsStream("2021/input/day01.txt")
                ))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[0]);
    }

}