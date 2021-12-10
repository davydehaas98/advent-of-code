package nl.davydehaas.year2021.day04;

import nl.davydehaas.utils.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        List<Integer> calledNumbers = getCalledNumbers();
        List<List<Integer[]>> boards = getBoards();
        int score = 0;
        
        for (Integer calledNumber : calledNumbers) {
            Iterator<List<Integer[]>> iterator = boards.iterator();
            while (iterator.hasNext()) {
                List<Integer[]> board = iterator.next();
                
                for (int i = 0; i < board.size(); i++) {
                    // Board contains called number
                    if (board.get(i)[0].equals(calledNumber)) {
                        board.get(i)[1] = 1;
                        // Check if the board has bingo
                        if (checkBingo(board)) {
                            if (boards.size() == 1) {
                                int sum = 0;
                                // Calculate sum of all unmarked numbers
                                for (Integer[] numbers : boards.get(0)) {
                                    if (numbers[1] == 0) {
                                        sum = sum + numbers[0];
                                    }
                                }
                                // Multiply by the last number called
                                score = sum * calledNumber;
                                break;
                            }
                            // Remove board that has bingo
                            iterator.remove();
                        }
                    }
                }
                if (score > 0) break;
            }
            if (score > 0) break;
        }
        
        System.out.println("The final score of the board that will win last is:");
        System.out.println(score);
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
        return Arrays
                .stream(InputReader.readFile("/_2021/day04-input.txt").get(0).split(","))
                .map(Integer::parseInt)
                .toList();
    }
    
    private static List<List<Integer[]>> getBoards() {
        List<Integer[]> board = new ArrayList<>();
        List<List<Integer[]>> boards = new ArrayList<>();
        
        List<String> lines = InputReader.readFile("/_2021/day04-input.txt");
        lines = lines.subList(1, lines.size());
        
        for (String line : lines) {
            if (!line.isEmpty()) {
                List<Integer> numbers = Arrays.stream(line.replace("  ", " ").split(" "))
                        .filter(s -> !s.isEmpty())
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
