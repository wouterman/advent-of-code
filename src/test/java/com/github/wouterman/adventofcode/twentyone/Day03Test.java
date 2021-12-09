package com.github.wouterman.adventofcode.twentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day03Test {

    private static final String INPUT_FILE = "input/day03.txt";

    private Day03 day03;

    @BeforeEach
    void init() {
        day03 = new Day03();
    }

    @ParameterizedTest
    @MethodSource("input")
    void solution(String[] commands, int expected) {
        int result = day03.solution(commands);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> input() throws IOException {
        return Stream.of(
                Arguments.of(new String[]{"00100", "11110", "10110", "10111", "10101", "01111",
                                "00111", "11100", "10000", "11001", "00010", "01010"}, 198),
                Arguments.of(TestHelper.getFromInputFile(INPUT_FILE), 852500)
        );
    }

}