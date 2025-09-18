package nl.davydehaas.adventofcode.year2021.day03;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2021, 3);
    
    void main() {
        timeSolution(Part1::solve);
    }
    
    static Number solve() {
        StringBuilder gammaRateStringBuilder = new StringBuilder();
        StringBuilder epsilonRateStringBuilder = new StringBuilder();
        
        for (int i = 0; i < 12; i++) {
            int balance = 0;
            
            for (String binaryNumber : INPUT) {
                if (binaryNumber.charAt(i) == '1') {
                    balance++;
                } else {
                    balance--;
                }
            }
            
            if (balance < 0) {
                gammaRateStringBuilder.append("0");
                epsilonRateStringBuilder.append("1");
            } else {
                gammaRateStringBuilder.append("1");
                epsilonRateStringBuilder.append("0");
            }
        }
        
        int gammaRate = Integer.parseInt(gammaRateStringBuilder.toString(), 2);
        int epsilonRate = Integer.parseInt(epsilonRateStringBuilder.toString(), 2);
        return gammaRate * epsilonRate;
    }
}
