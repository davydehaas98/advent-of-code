package main.java.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        List<String> binaryNumbers = getBinaryNumbers();
        StringBuilder gammaRateStringBuilder = new StringBuilder();
        StringBuilder epsilonRateStringBuilder = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int ratio = 0;

            for (String binaryNumber : binaryNumbers) {
                if (binaryNumber.charAt(i) == '1') ratio++;
                else ratio--;
            }

            if (ratio < 0) {
                gammaRateStringBuilder.append("0");
                epsilonRateStringBuilder.append("1");
            }
            else {
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
        List<String> binaryNumbers = new ArrayList<>();

        try {
            File file = new File("src/main/resources/day03-input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String binaryNumber = scanner.nextLine();
                binaryNumbers.add(binaryNumber);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return binaryNumbers;
    }
}
