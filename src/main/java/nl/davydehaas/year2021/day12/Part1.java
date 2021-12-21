package nl.davydehaas.year2021.day12;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import nl.davydehaas.utils.InputReader;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<String[]> connections = getConnections();
        List<Cave> caves = getCaves(connections);
        List<List<Cave>> paths = new ArrayList<>();
        
        Cave startPoint = caves.stream().filter(cave -> cave.getName().equals("start")).findAny().orElseThrow();
        Cave endPoint = caves.stream().filter(cave -> cave.getName().equals("start")).findAny().orElseThrow();
        
        calculatePath(startPoint, endPoint);
        
        System.out.println("The total paths that go through the caves and visit the small caves at most once is:");
        System.out.println(caves);
    }
    
    private static List<Cave> calculatePath(Cave startPoint, Cave endPoint) {
        return null;
    }
    
    
    private static List<Cave> getCaves(List<String[]> connections) {
        List<Cave> caves = new ArrayList<>();
        
        connections.forEach(connection -> {
            String startCaveName = connection[0];
            String endCaveName = connection[1];
            
            Cave startCave = caves.stream().filter(c -> c.getName().equals(startCaveName)).findAny().orElse(null);
            Cave endCave = caves.stream().filter(c -> c.getName().equals(endCaveName)).findAny().orElse(null);
    
            // Check if caves exist
            if (startCave == null) {
                startCave = new Cave(startCaveName);
                caves.add(startCave);
            }
            if (endCave == null) {
                endCave = new Cave(endCaveName);
                caves.add(endCave);
            }
            
            startCave.addConnectedCave(endCave);
            endCave.addConnectedCave(startCave);
        });
        
        return caves;
    }
    
    private static List<String[]> getConnections() {
        List<String[]> connections = new ArrayList<>();
        
        InputReader.readFile("/year2021/day12-input-test.txt")
                .forEach(l -> {
                    String[] connection = l.split("-");
                    connections.add(connection);
                });
        
        return connections;
    }
}

@Getter
class Cave {
    private String name;
    private boolean isSmallCave;
    private List<Cave> connectedCaves;
    private int visits;
    
    
    Cave(String name) {
        this.name = name;
        this.isSmallCave = Character.isLowerCase(name.charAt(0));
        this.connectedCaves = new ArrayList<>();
        this.visits = 0;
    }
    
    public void addConnectedCave(Cave connectedCave) {
        this.connectedCaves.add(connectedCave);
    }
    
    public void setVisits(int visits) {
        this.visits = visits;
    }
}
