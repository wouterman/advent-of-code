package com.github.wouterman.adventofcode.twentyone;

import java.nio.charset.StandardCharsets;

public class Day03 {

    private static final char ZERO = '0';
    private static final char ONE = '1';

    public int solution(String[] diagnosticReport) {
        int[][] count = new int[diagnosticReport[0].length()][2];
        for (String line : diagnosticReport) {
            byte[] asBytes = line.getBytes(StandardCharsets.UTF_8);
            for (int j = 0; j < asBytes.length; j++) {
                byte character = asBytes[j];
                if (character == ZERO) {
                    count[j][0]++;
                } else {
                    count[j][1]++;
                }
            }
        }

        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();

        for (int[] ints : count) {
            char gammaValue = ZERO;
            char epsilonValue = ZERO;
            if (ints[0] > ints[1]) {
                gammaValue = ONE;
            } else {
                epsilonValue = ONE;
            }
            epsilonRate.append(epsilonValue);
            gammaRate.append(gammaValue);
        }
        return Integer.parseInt(gammaRate.toString(), 2) * Integer.parseInt(epsilonRate.toString(), 2);
    }
}
