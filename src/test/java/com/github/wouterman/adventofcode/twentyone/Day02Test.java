package com.github.wouterman.adventofcode.twentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {

    private static final String INPUT_FILE = "input/day02.txt";

    private Day02 day02;

    @BeforeEach
    void init() {
        day02 = new Day02();
    }

    @ParameterizedTest
    @MethodSource("input")
    void solution(String[] commands, int expected) {
        int result = day02.solution(commands);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() throws IOException {
        return Stream.of(
                Arguments.of(new String[]{"forward 5", "down 0"}, 0),
                Arguments.of(new String[]{"forward 5", "down 5"}, 25),
                Arguments.of(new String[]{"forward 5", "down 5", "up 1"}, 20),
                Arguments.of(new String[]{"forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"}, 150),
                Arguments.of(TestHelper.getFromInputFile(INPUT_FILE), 1714680)
        );
    }

    @ParameterizedTest
    @MethodSource("inputPt2")
    void solution2(String[] commands, int expected) {
        int result = day02.solution2(commands);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputPt2() throws IOException {
        return Stream.of(
                Arguments.of(new String[]{"forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"}, 900),
                Arguments.of(TestHelper.getFromInputFile(INPUT_FILE), 1963088820)
        );
    }

}