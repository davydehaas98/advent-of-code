package main.java.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part1 {
    public static void main(String[] args) {
        List<Integer> calledNumbers = getCalledNumbers();
        List<LinkedHashMap<Integer, Boolean>> boards = getBoards();
        int score = 0;

        for (Integer calledNumber : calledNumbers) {
            for (LinkedHashMap<Integer, Boolean> board : boards) {
                if (board.containsKey(calledNumber)) {
                    board.put(calledNumber, true);
                    // Check if the board has bingo
                    if (checkBingo(board)) {
                        int sum = 0;
                        // Calculate sum of all unmarked numbers
                        for (Map.Entry<Integer, Boolean> entry : board.entrySet()) {
                            if (!entry.getValue()) {
                                sum = sum + entry.getKey();
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

        System.out.println("The final score of the board that will win first is:");
        System.out.println(score);
    }

    private static boolean checkBingo(LinkedHashMap<Integer, Boolean> board) {
        Boolean[] isMarked = board.values().toArray(new Boolean[0]);
        // Check horizontal
        for (int i = 0; i < 25; i += 5) {
            if (isMarked[i]
                && isMarked[i + 1]
                && isMarked[i + 2]
                && isMarked[i + 3]
                && isMarked[i + 4]) {
                return true;
            }
        }
        // Check vertical
        for (int i = 0; i < 5; i++) {
            if (isMarked[i]
                && isMarked[i + 5]
                && isMarked[i + 10]
                && isMarked[i + 15]
                && isMarked[i + 20]) {
                return true;
            }
        }

        return false;
    }

    private static List<Integer> getCalledNumbers() {
        List<Integer> numbers = new ArrayList<>();

        try {
            File file = new File("src/main/resources/day04-input.txt");
            Scanner scanner = new Scanner(file);
            String[] numberStrings = scanner.nextLine().split(",");
            scanner.close();

            for (String numberString : numberStrings) {
                numbers.add(Integer.parseInt(numberString));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return numbers;
    }

    private static List<LinkedHashMap<Integer, Boolean>> getBoards() {
        LinkedHashMap<Integer, Boolean> board = new LinkedHashMap<>();
        List<LinkedHashMap<Integer, Boolean>> boards = new ArrayList<>();

        try {
            File file = new File("src/main/resources/day04-input.txt");
            Scanner scanner = new Scanner(file);
            // Skip to boards
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();

                if (!row.isEmpty()) {
                    // Split numbers
                    row = row.replace("  ", ",");
                    row = row.replace(" ", ",");
                    String[] numberStrings = row.split(",");

                    for (String numberString : numberStrings) {
                        if (!numberString.isEmpty()) {
                            board.put(Integer.parseInt(numberString), false);
                        }
                    }
                }
                // Check if board has 25 numbers
                if (board.size() > 24) {
                    // Add to board list and clear the board
                    boards.add(board);
                    board = new LinkedHashMap<>();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return boards;
    }
}
