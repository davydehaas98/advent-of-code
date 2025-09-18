package nl.davydehaas.adventofcode.year2021.day03;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 3);
    
    static void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        List<String> binaryNumbers = INPUT;
        List<String> oxygenGeneratorRatings = binaryNumbers;
        List<String> co2ScrubberRatings = binaryNumbers;
        int bits = binaryNumbers.getFirst().length();

        for (int i = 0; i < bits; i++) {
            if (oxygenGeneratorRatings.size() > 1) {
                int balance = 0;

                for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                    if ('1' == oxygenGeneratorRating.charAt(i)) {
                        balance++;
                    } else {
                        balance--;
                    }
                }

                List<String> filteredList = new ArrayList<>();

                if (balance < 0) {
                    for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                        if ('0' == oxygenGeneratorRating.charAt(i)) {
                            filteredList.add(oxygenGeneratorRating);
                        }
                    }
                } else {
                    for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                        if ('1' == oxygenGeneratorRating.charAt(i)) {
                            filteredList.add(oxygenGeneratorRating);
                        }
                    }
                }

                oxygenGeneratorRatings = filteredList;
            }

            if (co2ScrubberRatings.size() > 1) {
                int balance = 0;

                for (String co2ScrubberRating : co2ScrubberRatings) {
                    if ('1' == co2ScrubberRating.charAt(i)) {
                        balance++;
                    } else {
                        balance--;
                    }
                }

                List<String> filteredList = new ArrayList<>();

                if (balance < 0) {
                    for (String co2ScrubberRating : co2ScrubberRatings) {
                        if ('1' == co2ScrubberRating.charAt(i)) {
                            filteredList.add(co2ScrubberRating);
                        }
                    }
                } else {
                    for (String co2ScrubberRating : co2ScrubberRatings) {
                        if ('0' == co2ScrubberRating.charAt(i)) {
                            filteredList.add(co2ScrubberRating);
                        }
                    }
                }

                co2ScrubberRatings = filteredList;
            }
        }

        int oxygenGeneratorRating = Integer.parseInt(oxygenGeneratorRatings.getFirst(), 2);
        int co2ScrubberRating = Integer.parseInt(co2ScrubberRatings.getFirst(), 2);
        return oxygenGeneratorRating * co2ScrubberRating;
    }
}
