package nl.davydehaas.adventofcode.year2021.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 4);
    
    void main() {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        List<Integer> calledNumbers = getCalledNumbers();
        List<List<Integer[]>> boards = getBoards();
        int score = 0;

        for (Integer calledNumber : calledNumbers) {
            for (List<Integer[]> board : boards) {
                for (int i = 0; i < board.size(); i++) {
                    // Board contains called number
                    if (board.get(i)[0].equals(calledNumber)) {
                        board.get(i)[1] = 1;
                        // Check if the board has bingo
                        if (checkBingo(board)) {
                            int sum = 0;
                            // Calculate sum of all unmarked numbers
                            for (Integer[] number : board) {
                                if (number[1] == 0) {
                                    sum = sum + number[0];
                                }
                            }
                            // Multiply by the last number called
                            score = sum * calledNumber;
                            break;
                        }
                    }
                }
                if (score > 0) {
                    break;
                }
            }
            if (score > 0) {
                break;
            }
        }

        return score;
    }

    private static boolean checkBingo(List<Integer[]> board) {
        // Check horizontal
        for (int i = 0; i < 25; i += 5) {
            if (board.get(i)[1] == 1
                    && board.get(i + 1)[1] == 1
                    && board.get(i + 2)[1] == 1
                    && board.get(i + 3)[1] == 1
                    && board.get(i + 4)[1] == 1
            ) {
                return true;
            }
        }
        // Check vertical
        for (int i = 0; i < 5; i++) {
            if (board.get(i)[1] == 1
                    && board.get(i + 5)[1] == 1
                    && board.get(i + 10)[1] == 1
                    && board.get(i + 15)[1] == 1
                    && board.get(i + 20)[1] == 1) {
                return true;
            }
        }

        return false;
    }

    private static List<Integer> getCalledNumbers() {
        return Arrays.stream(INPUT.getFirst().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private static List<List<Integer[]>> getBoards() {
        List<Integer[]> board = new ArrayList<>();
        List<List<Integer[]>> boards = new ArrayList<>();

        for (String line : INPUT.subList(1, INPUT.size())) {
            if (!line.isEmpty()) {
                List<Integer> numbers = Arrays.stream(line.replace("  ", " ").split(" "))
                        .filter(string -> !string.isEmpty())
                        .map(Integer::parseInt)
                        .toList();

                for (Integer number : numbers) {
                    board.add(new Integer[]{number, 0});
                }
            }
            // Check if board has 25 numbers
            if (board.size() == 25) {
                boards.add(board);
                board = new ArrayList<>();
            }
        }

        return boards;
    }
}
