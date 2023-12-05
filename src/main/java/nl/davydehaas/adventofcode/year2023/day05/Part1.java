package nl.davydehaas.adventofcode.year2023.day05;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day05.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static long calculate() {
        String[] seeds = INPUT.get(0)
                .substring(7)
                .split(" ");
        List<List<Map>> almanac = createAlmanac();
        List<Long> locations = new ArrayList<>();
        
        for (String seed : seeds) {
            long currentLocation = findProjection(Long.parseLong(seed), almanac);
            locations.add(currentLocation);
        }
        locations.sort(Long::compareTo);
        return locations.getFirst();
    }
    
    private static List<List<Map>> createAlmanac() {
        List<List<Map>> almanac = new ArrayList<>();
        List<Map> category = new ArrayList<>();
        
        for (int i = 2; i < INPUT.size(); i++) {
            String line = INPUT.get(i);
            if (line.isBlank()) {
                almanac.add(category);
                continue;
            }
            if (line.contains("map:")) {
                category = new ArrayList<>();
                continue;
            }
            String[] s = line.split(" ");
            category.add(new Map(Long.parseLong(s[0]), Long.parseLong(s[1]), Long.parseLong(s[2])));
        }
        almanac.add(category);
        
        return almanac;
    }
    
    private static long findProjection(long seed, List<List<Map>> almanac) {
        long destination = seed;
        for (List<Map> maps : almanac) {
            destination = calculatePosition(maps, destination);
        }
        
        return destination;
    }
    
    private static long calculatePosition(List<Map> maps, long from) {
        for (Map map : maps) {
            if (from >= map.source && from < map.source + map.range) {
                return from + map.destination - map.source;
            }
        }
        
        return from;
    }
    
    private record Map(long destination, long source, long range) {
    }
}
