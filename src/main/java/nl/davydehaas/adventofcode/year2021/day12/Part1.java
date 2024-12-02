package nl.davydehaas.adventofcode.year2021.day12;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 12);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static int solve() {
        Set<String[]> connections = getConnections();
        List<Cave> caves = getCaves(connections);
        List<List<Cave>> paths = new ArrayList<>();

        Cave startPoint = caves.stream().filter(cave -> cave.getName().equals("start")).findAny().orElseThrow();
        Cave endPoint = caves.stream().filter(cave -> cave.getName().equals("end")).findAny().orElseThrow();

        calculatePath(startPoint, endPoint);

        return caves.size();
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
        return INPUT.stream()
                .map(line -> line.split("-"))
                .collect(Collectors.toSet());
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
