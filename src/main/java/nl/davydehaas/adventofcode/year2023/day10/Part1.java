package nl.davydehaas.adventofcode.year2023.day10;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2023, 10, false);
    
    static void main() {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        char[][] tiles = new char[INPUT.size()][INPUT.size()];
        int startPositionX = 0;
        int startPositionY = 0;
        for (int y = 0; y < INPUT.size(); y++) {
            for (int x = 0; x < INPUT.size(); x++) {
                tiles[y][x] = INPUT.get(y).charAt(x);
                if (tiles[y][x] == 'S') {
                    // Set start position
                    startPositionX = x;
                    startPositionY = y;
                }
            }
        }

        Direction previousDirection;
        int currentX = startPositionX;
        int currentY = startPositionY;
        // Manual step since S is unknown
        if (getConnections(tiles[startPositionY][startPositionX - 1]).contains(Direction.EAST)) {
            currentX = currentX - 1;
            previousDirection = Direction.WEST;
        } else if (getConnections(tiles[startPositionY][startPositionX + 1]).contains(Direction.WEST)) {
            currentX = currentX + 1;
            previousDirection = Direction.EAST;
        } else if (getConnections(tiles[startPositionY - 1][startPositionX]).contains(Direction.NORTH)) {
            currentY = currentY - 1;
            previousDirection = Direction.SOUTH;
        } else {
            currentY = currentY + 1;
            previousDirection = Direction.NORTH;
        }
        int steps = 0;
        do {
            steps++;
            char tile = tiles[currentY][currentX];
            var connections = getConnections(tile);
            if (connections.contains(Direction.NORTH) && previousDirection != Direction.SOUTH) {
                currentY = currentY - 1;
                previousDirection = Direction.NORTH;
            } else if (connections.contains(Direction.SOUTH) && previousDirection != Direction.NORTH) {
                currentY = currentY + 1;
                previousDirection = Direction.SOUTH;
            } else if (connections.contains(Direction.EAST) && previousDirection != Direction.WEST) {
                currentX = currentX + 1;
                previousDirection = Direction.EAST;
            } else {
                currentX = currentX - 1;
                previousDirection = Direction.WEST;
            }
        } while (currentX != startPositionX || currentY != startPositionY);

        return steps / 2 + 1;
    }

    private static List<Direction> getConnections(char c) {
        return switch (c) {
            case '-' -> List.of(Direction.EAST, Direction.WEST);
            case '|' -> List.of(Direction.NORTH, Direction.SOUTH);
            case 'F' -> List.of(Direction.EAST, Direction.SOUTH);
            case 'J' -> List.of(Direction.NORTH, Direction.WEST);
            case 'L' -> List.of(Direction.NORTH, Direction.EAST);
            case '7' -> List.of(Direction.WEST, Direction.SOUTH);
            default -> List.of();
        };
    }

    private enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
}
