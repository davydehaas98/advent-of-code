package nl.davydehaas.adventofcode.year2021;

public class Runner2021 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("##### Day 01 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day01.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day01.Part2.main(args));
        System.out.println("##### Day 02 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day02.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day02.Part2.main(args));
        System.out.println("##### Day 03 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day03.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day03.Part2.main(args));
        System.out.println("##### Day 04 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day04.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day04.Part2.main(args));
        System.out.println("##### Day 05 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day05.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day05.Part2.main(args));
        System.out.println("##### Day 06 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day06.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day06.Part2.main(args));
        System.out.println("##### Day 07 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day07.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day07.Part2.main(args));
        System.out.println("##### Day 08 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day08.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day08.Part2.main(args));
        System.out.println("##### Day 09 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day09.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day09.Part2.main(args));
        System.out.println("##### Day 10 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day10.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day10.Part2.main(args));
        System.out.println("##### Day 11 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day11.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day11.Part2.main(args));
        System.out.println("##### Day 12 #####");
        System.out.println("----- Part 1 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day12.Part1.main(args));
        System.out.println("----- Part 2 -----");
        timeSolution(() -> nl.davydehaas.adventofcode.year2021.day12.Part2.main(args));
    }
    
    private static void timeSolution(Runnable runnable) throws InterruptedException {
        Thread thread = new Thread(runnable);
        long startTime = System.nanoTime();
        
        thread.start();
        thread.join();
        
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000F;
    
        System.out.println(duration + " ms");
    }
}
