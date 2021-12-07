package com.github.wouterman.adventofcode.twentyone;

public class Day02 {

    private static final String FORWARD = "forward";
    private static final String UP = "up";
    private static final String DOWN = "down";

    public int solution(String[] commands) {
        Position position = new Position();
        for (String command : commands) {
            String[] split = command.split(" ");
            String direction = split[0];
            int amount = Integer.parseInt(split[1]);

            if (FORWARD.equals(direction)) {
                position.incrementHorizontalPosition(amount);
            } else if (UP.equals(direction)) {
                position.decrementDepth(amount);
            } else if (DOWN.equals(direction)) {
                position.incrementDepth(amount);
            }
        }
        return position.calculateTotal();
    }

    public int solution2(String[] commands) {
        PositionWithAim position = new PositionWithAim();
        for (String command : commands) {
            String[] split = command.split(" ");
            String direction = split[0];
            int amount = Integer.parseInt(split[1]);
            if (FORWARD.equals(direction)) {
                position.incrementHorizontalPosition(amount);
            } else if (UP.equals(direction)) {
                position.decrementAim(amount);
            } else if (DOWN.equals(direction)) {
                position.incrementAim(amount);
            }
        }
        return position.calculateTotal();
    }

    private static class PositionWithAim extends Position {

        int aim;

        public void incrementAim(int toAdd) {
            aim += toAdd;
        }

        public void decrementAim(int toSubtract) {
            aim -= toSubtract;
        }

        @Override
        public void incrementHorizontalPosition(int toAdd) {
            super.incrementHorizontalPosition(toAdd);
            depth += (aim * toAdd);
        }

    }

    private static class Position {

        int horizontalPosition;
        int depth;

        public void incrementDepth(int toAdd) {
            depth += toAdd;
        }

        public void decrementDepth(int toSubtract) {
            depth -= toSubtract;
        }

        public void incrementHorizontalPosition(int toAdd) {
            horizontalPosition += toAdd;
        }

        public int calculateTotal() {
            return horizontalPosition * depth;
        }
    }
}
