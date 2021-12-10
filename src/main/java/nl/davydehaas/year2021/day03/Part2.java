package nl.davydehaas.year2021.day03;

import nl.davydehaas.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        List<String> binaryNumbers = getBinaryNumbers();
        List<String> oxygenGeneratorRatings = binaryNumbers;
        List<String> co2ScrubberRatings = binaryNumbers;
        int bits = binaryNumbers.get(0).length();
        
        for (int i = 0; i < bits; i++) {
            if (oxygenGeneratorRatings.size() > 1) {
                int balance = 0;
                
                for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                    if (oxygenGeneratorRating.charAt(i) == '1') balance++;
                    else balance--;
                }
                
                List<String> filteredList = new ArrayList<>();
                
                if (balance < 0) {
                    for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                        if (oxygenGeneratorRating.charAt(i) == '0')
                            filteredList.add(oxygenGeneratorRating);
                    }
                } else {
                    for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                        if (oxygenGeneratorRating.charAt(i) == '1')
                            filteredList.add(oxygenGeneratorRating);
                    }
                }
                
                oxygenGeneratorRatings = filteredList;
            }
            
            if (co2ScrubberRatings.size() > 1) {
                int balance = 0;
                
                for (String co2ScrubberRating : co2ScrubberRatings) {
                    if (co2ScrubberRating.charAt(i) == '1') balance++;
                    else balance--;
                }
                
                List<String> filteredList = new ArrayList<>();
                
                if (balance < 0) {
                    for (String co2ScrubberRating : co2ScrubberRatings) {
                        if (co2ScrubberRating.charAt(i) == '1')
                            filteredList.add(co2ScrubberRating);
                    }
                } else {
                    for (String co2ScrubberRating : co2ScrubberRatings) {
                        if (co2ScrubberRating.charAt(i) == '0')
                            filteredList.add(co2ScrubberRating);
                    }
                }
                
                co2ScrubberRatings = filteredList;
            }
        }
        
        int oxygenGeneratorRating = Integer.parseInt(oxygenGeneratorRatings.get(0), 2);
        int co2ScrubberRating = Integer.parseInt(co2ScrubberRatings.get(0), 2);
        int lifeSupportRating = oxygenGeneratorRating * co2ScrubberRating;
        
        System.out.println("The life support rating of the submarine is:");
        System.out.println(lifeSupportRating);
    }
    
    private static List<String> getBinaryNumbers() {
        return InputReader.readFile("/_2021/day03-input.txt");
    }
}
