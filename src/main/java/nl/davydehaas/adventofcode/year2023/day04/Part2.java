package nl.davydehaas.adventofcode.year2023.day04;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2023, 4);
    
    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }
    
    static int solve() {
        int[] totalCardsWon = new int[INPUT.size()];
        int sum = 0;
        for (int currentCard = 0; currentCard < INPUT.size(); currentCard++) {
            // Add original card
            totalCardsWon[currentCard]++;
            
            int won = getWinningNumbers(currentCard);
            
            for (int CardWonIndex = currentCard + 1; CardWonIndex < currentCard + won + 1; CardWonIndex++) {
                totalCardsWon[CardWonIndex] += totalCardsWon[currentCard];
            }
            sum += totalCardsWon[currentCard];
        }
        
        return sum;
    }
    
    private static int getWinningNumbers(int currentCard) {
        String[] match = INPUT.get(currentCard).split(" [|] ");
        String[] winningNumbers = match[0]
                .substring(match[0].indexOf(": ") + 2)
                .split(" ");
        String[] numbers = match[1].split(" ");
        
        int won = 0;
        for (String number : numbers) {
            if (number.isBlank()) {
                continue;
            }
            for (String winningNumber : winningNumbers) {
                if (winningNumber.equals(number)) {
                    won++;
                    break;
                }
            }
        }
        return won;
    }
}
