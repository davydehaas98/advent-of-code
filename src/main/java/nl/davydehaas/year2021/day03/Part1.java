package nl.davydehaas.year2021.day03;

import nl.davydehaas.utils.InputReader;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<String> binaryNumbers = getBinaryNumbers();
        StringBuilder gammaRateStringBuilder = new StringBuilder();
        StringBuilder epsilonRateStringBuilder = new StringBuilder();
        
        for (int i = 0; i < 12; i++) {
            int balance = 0;
            
            for (String binaryNumber : binaryNumbers) {
                if (binaryNumber.charAt(i) == '1') balance++;
                else balance--;
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
        int powerConsumption = gammaRate * epsilonRate;
        
        System.out.println("The power consumption of the submarine is:");
        System.out.print(powerConsumption);
    }
    
    private static List<String> getBinaryNumbers() {
        return InputReader.readFile("/_2021/day03-input.txt");
    }
}
