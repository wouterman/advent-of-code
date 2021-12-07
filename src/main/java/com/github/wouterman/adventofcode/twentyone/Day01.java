package com.github.wouterman.adventofcode.twentyone;

import java.util.Arrays;

public class Day01 {

    public int solution(String[] input) {
        int previous = Integer.parseInt(input[0]);
        int count = 0;
        for (int i = 1; i < input.length; i++) {
            int measurement = Integer.parseInt(input[i]);
            if (measurement > previous) {
                count++;
            }
            previous = measurement;
        }
        return count;
    }

    public int solution2(String[] input) {
        if (input.length < 3) {
            return 0;
        }
        int[] measurements = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int previous = measurements[0] + measurements[1] + measurements[2];
        int count = 0;
        for (int i = 1; i < input.length - 2; i++) {
            int sum  = measurements[i] + measurements[i + 1] + measurements[i + 2];
            if (sum > previous) {
                count++;
            }
            previous = sum;
        }
        return count;
    }

}