package nl.davydehaas.adventofcode.year2021.day03;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 3);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static int solve() {
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
