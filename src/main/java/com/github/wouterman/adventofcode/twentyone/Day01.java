package com.github.wouterman.adventofcode.twentyone;

import java.util.Arrays;

public class Day01 {

    public int solution(String[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }

        int[] measurements = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int previous = measurements[0];
        int count = 0;
        for (int i = 1; i < measurements.length; i++) {
            int measurement = measurements[i];
            if (measurement > previous) {
                count++;
            }
            previous = measurement;
        }
        return count;
    }

}