package com.github.wouterman.adventofcode.twentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {

    private static final String INPUT_FILE = "input/day01.txt";

    private Day01 day01;

    @BeforeEach
    void init() {
        day01 = new Day01();
    }

    @ParameterizedTest
    @MethodSource("input")
    void solution(String[] measurements, int expected) {
        int result = day01.solution(measurements);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() throws IOException {
        return Stream.of(
                Arguments.of(new String[]{"200", "199"}, 0),
                Arguments.of(new String[]{"199", "200"}, 1),
                Arguments.of(new String[]{"199", "200", "201"}, 2),
                Arguments.of(new String[]{"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"}, 7),
                Arguments.of(TestHelper.getFromInputFile(INPUT_FILE), 1477)
        );
    }

    @ParameterizedTest
    @MethodSource("pt2input")
    void solution2(String[] measurements, int expected) {
        int result = day01.solution2(measurements);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> pt2input() throws IOException {
        return Stream.of(
                Arguments.of(new String[0], 0),
                Arguments.of(new String[]{"200", "199"}, 0),
                Arguments.of(new String[]{"199", "200"}, 0),
                Arguments.of(new String[]{"199", "200", "201", "202" }, 1),
                Arguments.of(new String[]{"199", "200", "201", "202", "203" }, 2),
                Arguments.of(new String[]{"199", "200", "208", "210", "200" }, 1),
                Arguments.of(new String[]{"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"}, 5),
                Arguments.of(TestHelper.getFromInputFile(INPUT_FILE), 1523)
        );
    }
}