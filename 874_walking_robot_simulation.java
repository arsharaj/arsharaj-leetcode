// @lc app=leetcode id=874 lang=java

import java.util.HashSet;

class Solution {
    private class Coordinate {
        private int x;
        private int y;
        private char direction;
        private int distance;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.direction = 'N';
        }
        public void executeCommand(int steps) {
            if (steps == -1) {
                switch (direction) {
                    case 'N': direction = 'E'; break;
                    case 'E': direction = 'S'; break;
                    case 'W': direction = 'N'; break;
                    case 'S': direction = 'W'; break;
                }
            }
            if (steps == -2) {
                switch (direction) {
                    case 'N': direction = 'W'; break;
                    case 'E': direction = 'N'; break;
                    case 'W': direction = 'S'; break;
                    case 'S': direction = 'E'; break;
                }
            }
            int prevX;
            int prevY;
            while (steps > 0) {
                prevX = x;
                prevY = y;
                switch (direction) {
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                    case 'S': y--; break;
                }
                if (obstaclesSet.contains(this)) {
                    x = prevX;
                    y = prevY;
                    break;
                }
                distance = Math.max(distance, x * x + y * y);
                steps--;
            }
        }
        public int furthestDistance() {
            return distance;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Coordinate)) return false;
            Coordinate coordinate = (Coordinate) obj;
            return this.x == coordinate.x && this.y == coordinate.y;
        }
        @Override
        public int hashCode() {
            return 10 * x + y;
        }
    }
    private HashSet<Coordinate> obstaclesSet = new HashSet<>();
    public int robotSim(int[] commands, int[][] obstaclesArr) {
        for (int[] obstacle : obstaclesArr)
            obstaclesSet.add(new Coordinate(obstacle[0], obstacle[1]));
        Coordinate robot = new Coordinate(0, 0);
        for (int command : commands) {
            robot.executeCommand(command);
        }
        return robot.furthestDistance();
    }
}
