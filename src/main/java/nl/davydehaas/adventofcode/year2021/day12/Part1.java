package nl.davydehaas.adventofcode.year2021.day12;

import nl.davydehaas.adventofcode.utils.InputReader;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Part1 {
    public static void main(String[] args) {
        Set<String[]> connections = getConnections();
        List<Cave> caves = getCaves(connections);
        List<List<Cave>> paths = new ArrayList<>();
        
        Cave startPoint = caves.stream().filter(cave -> cave.getName().equals("start")).findAny().orElseThrow();
        Cave endPoint = caves.stream().filter(cave -> cave.getName().equals("end")).findAny().orElseThrow();
        
        calculatePath(startPoint, endPoint);
        
        System.out.println("The total paths that go through the caves and visit the small caves at most once is:");
        System.out.println(caves);
    }
    
    private static List<Cave> getCaves(Set<String[]> connections) {
        List<Cave> caves = new ArrayList<>();
        
        connections.forEach(connection -> {
            String cave1Name = connection[0];
            String cave2Name = connection[1];
            
            Cave cave1 = caves.stream().filter(c -> c.getName().equals(cave1Name)).findAny().orElse(null);
            Cave cave2 = caves.stream().filter(c -> c.getName().equals(cave2Name)).findAny().orElse(null);
            
            // Check if caves exist
            if (cave1 == null) {
                cave1 = new Cave(cave1Name);
                caves.add(cave1);
            }
            if (cave2 == null) {
                cave2 = new Cave(cave2Name);
                caves.add(cave2);
            }
            
            cave1.addConnection(cave2);
            cave2.addConnection(cave1);
        });
        
        return caves;
    }
    
    private static List<Cave> calculatePath(Cave startPoint, Cave endPoint) {
        return null;
    }
    
    private static Set<String[]> getConnections() {
        Set<String[]> connections = new LinkedHashSet<>();
        
        InputReader.readFile("/year2021/day12-input-test.txt")
                .forEach(line -> {
                    String[] connection = line.split("-");
                    connections.add(connection);
                });
        
        return connections;
    }
    
    static class Cave {
        final String name;
        final boolean big;
        final Set<Cave> connections = new LinkedHashSet<>();
    
        public Cave(String name) {
            this.name = name;
            this.big = Character.isUpperCase(name.charAt(0));
        }
        
        public String getName() {
            return name;
        }
    
        public boolean isBig() {
            return big;
        }
    
        public Set<Cave> getConnections() {
            return connections;
        }
        
        public void addConnection(Cave cave) {
            connections.add(cave);
        }
    }
}
